package com.mullatoes.retrofit2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel(
    private val userRepository: UserRepository
) : ViewModel(){

    private val _users = MutableLiveData<User>()
    val users: LiveData<User> = _users

    fun getAllUsers() {
        viewModelScope.launch {
            _users.value = userRepository.getAllUsers()
        }
    }
}
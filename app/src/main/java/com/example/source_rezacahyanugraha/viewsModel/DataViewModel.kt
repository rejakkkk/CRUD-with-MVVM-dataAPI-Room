package com.example.source_rezacahyanugraha.viewsModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.source_rezacahyanugraha.model.DataResponse
import com.example.source_rezacahyanugraha.model.ModelData
import com.example.source_rezacahyanugraha.repository.DataRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DataViewModel(private val dataRepository: DataRepository) : ViewModel() {


    init {
        viewModelScope.launch(Dispatchers.IO) {
            dataRepository.getData()
        }
    }

    val data: LiveData<DataResponse> get() = dataRepository.data

    fun deleteData(data: ModelData) {
        viewModelScope.launch(Dispatchers.IO) {
            dataRepository.deleteData(data)
        }
    }

    fun addData(data: ModelData){
        viewModelScope.launch(Dispatchers.IO) {
            dataRepository.insertData(data)
        }
    }
}
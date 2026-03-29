package com.pixcake

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pixcake.ai.AiEngine
import com.pixcake.camera.CameraManager
import com.pixcake.database.AppDatabase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.File

class MainViewModel(
    private val aiEngine: AiEngine,
    private val cameraManager: CameraManager,
    private val database: AppDatabase
) : ViewModel() {
    
    private val _selectedImage = MutableStateFlow<File?>(null)
    val selectedImage: StateFlow<File?> = _selectedImage.asStateFlow()
    
    private val _processing = MutableStateFlow(false)
    val processing: StateFlow<Boolean> = _processing.asStateFlow()
    
    private val _currentEffect = MutableStateFlow("color_track")
    val currentEffect: StateFlow<String> = _currentEffect.asStateFlow()
    
    private val _intensity = MutableStateFlow(0.5f)
    val intensity: StateFlow<Float> = _intensity.asStateFlow()
    
    fun setImage(file: File) {
        _selectedImage.value = file
    }
    
    fun captureImage() {
        viewModelScope.launch {
            cameraManager.captureImage()?.let { file ->
                _selectedImage.value = file
            }
        }
    }
    
    fun setEffect(effectType: String) {
        _currentEffect.value = effectType
    }
    
    fun setIntensity(value: Float) {
        _intensity.value = value
    }
    
    fun processImage() {
        val imageFile = _selectedImage.value ?: return
        
        viewModelScope.launch {
            _processing.value = true
            
            try {
                val result = aiEngine.processImage(
                    imageFile,
                    _currentEffect.value,
                    _intensity.value
                )
                
                result.onSuccess { processedFile ->
                    _selectedImage.value = processedFile
                    
                    // 保存到历史记录
                    database.editHistoryDao().insert(
                        com.pixcake.database.entity.EditHistory(
                            effectType = _currentEffect.value,
                            originalPath = imageFile.absolutePath,
                            processedPath = processedFile.absolutePath,
                            timestamp = System.currentTimeMillis()
                        )
                    )
                }
            } finally {
                _processing.value = false
            }
        }
    }
}

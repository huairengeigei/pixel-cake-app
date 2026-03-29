package com.pixcake.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.pixcake.MainViewModel
import com.pixcake.ui.components.SliderControl
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreen(
    viewModel: MainViewModel = koinViewModel()
) {
    val selectedImage by viewModel.selectedImage.collectAsState()
    val processing by viewModel.processing.collectAsState()
    val currentEffect by viewModel.currentEffect.collectAsState()
    val intensity by viewModel.intensity.collectAsState()
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Pixel Cake") },
                actions = {
                    IconButton(onClick = { viewModel.captureImage() }) {
                        Text("📷")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 图片预览区域
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .background(Color.Gray.copy(alpha = 0.3f)),
                contentAlignment = Alignment.Center
            ) {
                if (selectedImage != null) {
                    Text("图片预览")
                } else {
                    Text("请选择或拍照")
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // AI 效果选择
            Text("选择 AI 效果", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(12.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                EffectButton("AI 追色", "color_track", currentEffect, viewModel)
                EffectButton("换天空", "sky_replace", currentEffect, viewModel)
                EffectButton("保留人脸", "face_retain", currentEffect, viewModel)
                EffectButton("风格迁移", "style_transfer", currentEffect, viewModel)
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // 强度控制
            SliderControl(
                label = "效果强度",
                value = intensity,
                onValueChange = { viewModel.setIntensity(it) }
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // 处理按钮
            Button(
                onClick = { viewModel.processImage() },
                enabled = selectedImage != null && !processing,
                modifier = Modifier.fillMaxWidth()
            ) {
                if (processing) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(20.dp),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                } else {
                    Text("应用 AI 效果")
                }
            }
        }
    }
}

@Composable
fun EffectButton(
    label: String,
    effectType: String,
    currentEffect: String,
    viewModel: MainViewModel
) {
    val selected = currentEffect == effectType
    Button(
        onClick = { viewModel.setEffect(effectType) },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
        ),
        modifier = Modifier.width(100.dp)
    ) {
        Text(label)
    }
}

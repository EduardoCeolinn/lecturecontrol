package com.lecturecontrol.di

import com.lecturecontrol.data.local.datasource.SpeakerDataSource
import com.lecturecontrol.data.local.repository.SpeakerRepositoryImpl
import com.lecturecontrol.domain.repository.SpeakerRepository
import com.lecturecontrol.domain.usecase.GetSpeakerUseCase
import com.lecturecontrol.presentation.viewmodel.SpeakerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val speakerModule = module {
    single { SpeakerDataSource() }
    single<SpeakerRepository> { SpeakerRepositoryImpl(get()) }
    factory { GetSpeakerUseCase(get()) }
    viewModel { SpeakerViewModel(get()) }
}

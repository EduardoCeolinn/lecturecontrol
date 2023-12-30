package com.lecturecontrol.di

import com.lecturecontrol.data.local.datasource.LectureDataSource
import com.lecturecontrol.data.local.repository.LectureRepositoryImpl
import com.lecturecontrol.domain.repository.LectureRepository
import com.lecturecontrol.domain.usecase.GetLecturesUseCase
import com.lecturecontrol.presentation.viewmodel.LectureListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val lectureModule = module {
    single { LectureDataSource() }
    single<LectureRepository> { LectureRepositoryImpl(get()) }
    factory { GetLecturesUseCase(get()) }
    viewModel { LectureListViewModel(get()) }
}


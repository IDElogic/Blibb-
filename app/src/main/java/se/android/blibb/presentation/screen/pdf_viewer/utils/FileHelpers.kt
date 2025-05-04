package se.android.blibb.presentation.screen.pdf_viewer.utils

import java.util.Date

internal fun provideFileName(): String {
    return "${Date().time}.pdf"
}
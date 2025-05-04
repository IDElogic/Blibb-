package se.android.blibb.utils

import se.android.blibb.R
import se.android.blibb.domain.model.*

object DataDummy {

    fun generateDummyProduct(): List<ProductItem> {
        return listOf(
            ProductItem(
                id = 1,
                title = "Description",
                description = "Lorem ipsum",
                image = R.drawable.bicycle_02,
                unit = "Lorem ipsum",
                price = 1200.0,
                nutritions = "",
                review = 3.5,
            ),
            ProductItem(
                id = 2,
                title = "Description",
                description = "Lorem ipsum",
                image = R.drawable.bicycle_03,
                unit = "Lorem ipsum",
                price = 1800.0,
               nutritions = "",
                review = 5.0
            ),
            ProductItem(
                id = 3,
                title = "Description",
                description = "Lorem ipsum",
                image = R.drawable.bicycle_01,
                unit = "Lorem ipsum",
                price = 900.00,
                nutritions = "",
                review = 4.0
            ),
            ProductItem(
                id = 4,
                title = "Description",
                description = "Lorem ipsum",
                image = R.drawable.bicycle_02,
                unit = "Lorem ipsum",
                price = 2200.0,
                nutritions = "",
                review = 4.7
            ),
            ProductItem(
                id = 5,
                title = "Description",
                description = "Lorem ipsum",
                image = R.drawable.bicycle_03,
                unit = "Lorem ipsum",
                price = 1700.0,
                nutritions = "",
                review = 4.2
            ),
            ProductItem(
                id = 6,
                title = "Description",
                description = "Lorem ipsum",
                image = R.drawable.bicycle_01,
                unit = "Lorem ipsum",
                price = 3200.0,
                nutritions = "",
                review = 3.8
            ),
            ProductItem(
                id = 7,
                title = "Description",
                description = "Lorem ipsum",
                image = R.drawable.bicycle_02,
                unit = "Lorem ipsum",
                price = 4200.0,
                nutritions = "",
                review = 3.0
            ),
            ProductItem(
                id = 8,
                title = "Description",
                description = "Lorem ipsum",
                image = R.drawable.bicycle_03,
                unit = "Lorem ipsum",
                price = 1000.0,
                nutritions = "",
                review = 4.2
            ),
            ProductItem(
                id = 9,
                title = "Description",
                description = "Lorem ipsum",
                image = R.drawable.bicycle_01,
                unit = "Lorem ipsum",
                price = 2200.0,
                nutritions = "",
                review = 4.7
            ),
            ProductItem(
                id = 10,
                title = "Description",
                description = "Lorem ipsum",
                image = R.drawable.bicycle_03,
                unit = "Lorem ipsum",
                price = 1900.0,
                nutritions = "",
                review = 4.5
            ),
        )
    }

    fun generateDummyAbout(): List<AboutItem> {
        return listOf(
            AboutItem(
                image = R.drawable.baseline_attach_file_24,
                title = "Attached files"
            ),
            AboutItem(
                image = R.drawable.ic_launcher_foreground,
                title = "Details"
            ),
            AboutItem(
                image = R.drawable.ic_launcher_foreground,
                title = "Location"
            ),
            AboutItem(
                image = R.drawable.ic_launcher_foreground,
                title = "Website"
            ),
            AboutItem(
                image = R.drawable.ic_launcher_foreground,
                title = "GitHub"
            ),
        )
    }

}
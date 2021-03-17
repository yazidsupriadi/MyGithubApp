package com.example.mygithub

import Github

object GithubData {
    private val githubNames = arrayOf(
            "Aditya Fitriadi",
            "Auzan Assidqi",
            "Muhammad Yazid Supriadi",
            "Huda Izzatul Haq",
            "Wishnutama",
            "Nadiem Makariem",
            "Sundar Pichai",
            "Jan Koum",
            "Mark Zuckenberg",
            "Bill Gates"


    )
    private val githubUsernames = arrayOf(
        "featriadi",
        "Auzanassqi",
        "yazid supriadi",
        "hudaizzhaq",
        "Wishnutama",
        "nadiemmakariem",
        "sundarpichai",
        "jankoum",
        "markzuckenberg",
        "billgates"


    )

    private val githubPhotos = intArrayOf(
        R.drawable.adit,
        R.drawable.auzan,
        R.drawable.yazid,
        R.drawable.huda,
        R.drawable.wisnutama,
        R.drawable.nadiem_makarim,
        R.drawable.sundar_pichai,
        R.drawable.jan_koum,
        R.drawable.mark_zuckernberg,
        R.drawable.bill_gates,
    )

    val listData: ArrayList<Github>
        get() {
            val list = arrayListOf<Github>()
            for (position in githubNames.indices) {
                val github = Github()
                github.name = githubNames[position]
                github.username = githubUsernames[position]
                github.photo = githubPhotos[position]
                list.add(github)
            }
            return list
        }
}
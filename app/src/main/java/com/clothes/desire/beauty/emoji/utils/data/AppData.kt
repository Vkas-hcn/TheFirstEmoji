package com.clothes.desire.beauty.emoji.utils.data

import com.clothes.desire.beauty.emoji.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object AppData {
    //根据json数据获取Bean
    fun getEmojiList(jsonData: String): EmojiBean {
        return try {
            Gson().fromJson(jsonData, object : TypeToken<EmojiBean>() {}.type)
                ?: EmojiBean(
                    eye = listOf(""),
                    face = listOf(""),
                    mouth = listOf(""),
                    hand = listOf("")
                )
        } catch (e: Exception) {
            EmojiBean(eye = listOf(""), face = listOf(""), mouth = listOf(""), hand = listOf(""))
        }
    }

    val iconDown1 = listOf(
        R.drawable.main_item_icons_animal2,
        R.drawable.emoji_mixer_item_animal_1,
        R.drawable.emoji_mixer_item_animal_2,
        R.drawable.emoji_mixer_item_animal_3,
        R.drawable.emoji_mixer_item_animal_4,
        R.drawable.emoji_mixer_item_animal_5,
        R.drawable.emoji_mixer_item_animal_6,
        R.drawable.emoji_mixer_item_animal_7,
        R.drawable.emoji_mixer_item_animal_8,
        R.drawable.emoji_mixer_item_animal_9,
        R.drawable.emoji_mixer_item_animal_10,
        R.drawable.emoji_mixer_item_animal_11,
        R.drawable.emoji_mixer_item_animal_12,
        R.drawable.emoji_mixer_item_animal_13,
        R.drawable.emoji_mixer_item_animal_14,
        R.drawable.emoji_mixer_item_animal_15,
        R.drawable.emoji_mixer_item_animal_16,
        R.drawable.emoji_mixer_item_animal_17,
        R.drawable.emoji_mixer_item_animal_18,
        R.drawable.emoji_mixer_item_animal_19,
        R.drawable.emoji_mixer_item_animal_20,
        R.drawable.emoji_mixer_item_animal_21,
        R.drawable.emoji_mixer_item_animal_22,
        R.drawable.emoji_mixer_item_animal_23,
        R.drawable.emoji_mixer_item_animal_24,
        R.drawable.main_item_icons_animal1,
        R.drawable.main_item_icons_animal3,
        R.drawable.main_item_icons_animal4,
        R.drawable.main_item_icons_animal5,
        R.drawable.main_item_icons_animal6,
        R.drawable.main_item_icons_animal7,
        R.drawable.main_item_icons_animal8,
        R.drawable.main_item_icons_animal9
    )

    val iconDown2 = listOf(
        R.drawable.main_item_icons_fruit1,
        R.drawable.main_item_icons_fruit2,
        R.drawable.main_item_icons_fruit3,
        R.drawable.main_item_icons_fruit4,
        R.drawable.main_item_icons_fruit5,
        R.drawable.main_item_icons_fruit6,
        R.drawable.main_item_icons_fruit7,
        R.drawable.main_item_icons_fruit8
    )
    val iconDown3 = listOf(
        R.drawable.emoji_mixer_item_fruits_6,
        R.drawable.emoji_mixer_item_fruits_1,
        R.drawable.emoji_mixer_item_fruits_2,
        R.drawable.emoji_mixer_item_fruits_3,
        R.drawable.emoji_mixer_item_fruits_4,
        R.drawable.emoji_mixer_item_fruits_5,
        R.drawable.emoji_mixer_item_fruits_7,
        R.drawable.emoji_mixer_item_fruits_8,
        R.drawable.emoji_mixer_item_fruits_9,
        R.drawable.emoji_mixer_item_fruits_10,
        R.drawable.emoji_mixer_item_fruits_11,
        R.drawable.emoji_mixer_item_fruits_14,
        R.drawable.emoji_mixer_item_fruits_15,
        R.drawable.emoji_mixer_item_fruits_16,
        R.drawable.emoji_mixer_item_fruits_17,
        R.drawable.emoji_mixer_item_fruits_22,
        R.drawable.emoji_mixer_item_fruits_23,
    )

    val iconDown4 = listOf(
        R.drawable.main_item_icons_3d1,
        R.drawable.main_item_icons_3d2,
        R.drawable.main_item_icons_3d3,
        R.drawable.main_item_icons_3d4,
        R.drawable.main_item_icons_3d5,
        R.drawable.main_item_icons_3d6,
        R.drawable.main_item_icons_3d7,
        R.drawable.main_item_icons_emoji7,
        R.drawable.main_item_icons_emoji9,
        R.drawable.main_item_icons_line4,
    )

    val iconDown5 = listOf(
        R.drawable.main_item_icons_emoji5,
        R.drawable.main_item_icons_emoji1,
        R.drawable.main_item_icons_emoji2,
        R.drawable.main_item_icons_emoji3,
        R.drawable.main_item_icons_fruit9,
        R.drawable.main_item_icons_line5,
        R.drawable.main_item_icons_line12,
        R.drawable.main_item_icons_smile1,
        R.drawable.main_item_icons_smile3,
        R.drawable.main_item_icons_smile4,
        R.drawable.main_item_icons_smile5,
        R.drawable.main_item_icons_smile7,
    )

    val iconDown6 = listOf(
        R.drawable.emoji_mixer_item_heart_6,
        R.drawable.emoji_mixer_item_heart_1,
        R.drawable.emoji_mixer_item_heart_2,
        R.drawable.emoji_mixer_item_heart_3,
        R.drawable.emoji_mixer_item_heart_4,
        R.drawable.emoji_mixer_item_heart_5,
        R.drawable.emoji_mixer_item_heart_7,
        R.drawable.emoji_mixer_item_heart_8,
        R.drawable.emoji_mixer_item_heart_9,
        R.drawable.emoji_mixer_item_heart_10,
        R.drawable.emoji_mixer_item_heart_11,
        R.drawable.emoji_mixer_item_heart_12,
        R.drawable.emoji_mixer_item_heart_13,
        R.drawable.emoji_mixer_item_heart_14,
        R.drawable.emoji_mixer_item_heart_15,
        R.drawable.emoji_mixer_item_heart_16,
        R.drawable.main_item_icons_emoji6,
    )

    val iconDown7 = listOf(
        R.drawable.emoji_mixer_item_flower_16,
        R.drawable.emoji_mixer_item_flower_1,
        R.drawable.emoji_mixer_item_flower_2,
        R.drawable.emoji_mixer_item_flower_3,
        R.drawable.emoji_mixer_item_flower_4,
        R.drawable.emoji_mixer_item_flower_5,
        R.drawable.emoji_mixer_item_flower_6,
        R.drawable.emoji_mixer_item_flower_7,
        R.drawable.emoji_mixer_item_flower_8,
        R.drawable.emoji_mixer_item_flower_9,
        R.drawable.emoji_mixer_item_flower_10,
        R.drawable.emoji_mixer_item_flower_11,
        R.drawable.emoji_mixer_item_flower_12,
        R.drawable.emoji_mixer_item_flower_13,
        R.drawable.emoji_mixer_item_flower_14,
        R.drawable.emoji_mixer_item_flower_15,
        R.drawable.emoji_mixer_item_flower_17,
        R.drawable.emoji_mixer_item_flower_18,
        R.drawable.emoji_mixer_item_flower_19,
        R.drawable.emoji_mixer_item_flower_20,
        R.drawable.emoji_mixer_item_flower_other_3,
        R.drawable.emoji_mixer_item_flower_other_17,
    )

    val iconDown8 = listOf(
        R.drawable.main_item_icons_3d8,
        R.drawable.main_item_icons_cry1,
        R.drawable.main_item_icons_cry2,
        R.drawable.main_item_icons_cry3,
        R.drawable.main_item_icons_cry4,
        R.drawable.main_item_icons_cry5,
        R.drawable.main_item_icons_emoji4,
    )


    val emoji1Json = """
        {
            "face": [
            "emoji_mixer_item_face_1",
            "emoji_mixer_item_face_1",
            "emoji_mixer_item_face_5",
            "emoji_mixer_item_face_1",
            
            "emoji_mixer_item_face_1",
            "emoji_mixer_item_face_1",
            "emoji_mixer_item_face_1",
            "emoji_mixer_item_face_1",
            
            "emoji_mixer_item_face_1",
            "emoji_mixer_item_face_1",
            "emoji_mixer_item_face_1",
            "emoji_mixer_item_face_1",
            
            "emoji_mixer_item_face_1",
            "emoji_mixer_item_face_1",
            "emoji_mixer_item_face_1",
            "emoji_mixer_item_face_1",
            
            "emoji_mixer_item_face_3",
            "emoji_mixer_item_face_1",
            "emoji_mixer_item_face_1",
            "emoji_mixer_item_face_1",
            
            "emoji_mixer_item_face_1",
            "emoji_mixer_item_face_1",
            "emoji_mixer_item_face_4",
            "emoji_mixer_item_face_1",
            
            "emoji_mixer_item_face_1",
            "emoji_mixer_item_face_3",
            "emoji_mixer_item_face_1",
            "emoji_mixer_item_face_1",
            
            
            "emoji_mixer_item_face_2",
            "emoji_mixer_item_face_3",
            "emoji_mixer_item_face_4",
            "emoji_mixer_item_face_5",
            
            "emoji_mixer_item_face_6",
            "emoji_mixer_item_face_2",
            "emoji_mixer_item_face_3",
            "emoji_mixer_item_face_1",
            
            "emoji_mixer_item_face_6",
            "emoji_mixer_item_face_6",
            "emoji_mixer_item_face_2",
            "emoji_mixer_item_face_3",
            ],
            "eye": [
            "emoji_mixer_item_eye_1",
            "emoji_mixer_item_eye_4",
            "emoji_mixer_item_eye_3",
            "emoji_mixer_item_eye_24",
            
            "emoji_mixer_item_eye_2",
            "emoji_mixer_item_eye_7",
            "emoji_mixer_item_eye_8",
            "emoji_mixer_item_eye_9",
            
            "emoji_mixer_item_eye_6",
            "emoji_mixer_item_eye_10",
            "emoji_mixer_item_eye_11",
            "emoji_mixer_item_eye_12",
            
            "emoji_mixer_item_eye_13",
            "emoji_mixer_item_eye_14",
            "emoji_mixer_item_eye_15",
            "emoji_mixer_item_eye_16",
            
            "emoji_mixer_item_eye_17",
            "emoji_mixer_item_eye_18",
            "emoji_mixer_item_eye_19",
            "emoji_mixer_item_eye_20",
            
            "emoji_mixer_item_eye_21",
            "emoji_mixer_item_eye_22",
            "emoji_mixer_item_eye_23",
            "emoji_mixer_item_eye_24",
            
            "emoji_mixer_item_eye_25",
            "emoji_mixer_item_eye_26",
            "emoji_mixer_item_eye_27",
            "emoji_mixer_item_eye_28",
            
            "emoji_mixer_item_eye_29",
            "emoji_mixer_item_eye_30",
            "emoji_mixer_item_eye_3",
            "emoji_mixer_item_eye_4",
            
            "emoji_mixer_item_eye_11",
            "emoji_mixer_item_eye_12",
            "emoji_mixer_item_eye_13",
            "emoji_mixer_item_eye_14",
            
            "emoji_mixer_item_eye_15",
            "emoji_mixer_item_eye_16",
            "emoji_mixer_item_eye_17",
            "emoji_mixer_item_eye_18",
            ],
            "mouth": [
            "emoji_mixer_item_mouth_1",
            "emoji_mixer_item_mouth_2",
            "emoji_mixer_item_mouth_3",
            "emoji_mixer_item_mouth_4",
            
            "emoji_mixer_item_mouth_5",
            "emoji_mixer_item_mouth_6",
            "emoji_mixer_item_mouth_7",
            "emoji_mixer_item_mouth_8",
            
            "emoji_mixer_item_mouth_9",
            "emoji_mixer_item_mouth_10",
            "emoji_mixer_item_mouth_11",
            "emoji_mixer_item_mouth_12",
            
            "emoji_mixer_item_mouth_13",
            "emoji_mixer_item_mouth_14",
            "emoji_mixer_item_mouth_15",
            "emoji_mixer_item_mouth_16",
            
            "emoji_mixer_item_mouth_17",
            "emoji_mixer_item_mouth_18",
            "emoji_mixer_item_mouth_19",
            "emoji_mixer_item_mouth_20",
            
            "emoji_mixer_item_mouth_21",
            "emoji_mixer_item_mouth_22",
            "emoji_mixer_item_mouth_23",
            "emoji_mixer_item_mouth_24",
            
            "emoji_mixer_item_mouth_25",
            "emoji_mixer_item_mouth_26",
            "emoji_mixer_item_mouth_27",
            "emoji_mixer_item_mouth_28",
            
            "emoji_mixer_item_mouth_29",
            "emoji_mixer_item_mouth_30",
            "emoji_mixer_item_mouth_31",
            "emoji_mixer_item_mouth_32",
            
            "emoji_mixer_item_mouth_15",
            "emoji_mixer_item_mouth_16",
            "emoji_mixer_item_mouth_17",
            "emoji_mixer_item_mouth_18",
            
            "emoji_mixer_item_mouth_29",
            "emoji_mixer_item_mouth_20",
            "emoji_mixer_item_mouth_21",
            "emoji_mixer_item_mouth_22",
            ],
            "hand": [
            "",
            "",
            "",
            "",
            
            "",
            "emoji_mixer_item_hand_10",
            "",
            "",
            
            "emoji_mixer_item_hand_17",
            "",
            "",
            "",
            
            "emoji_mixer_item_hand_13",
            "emoji_mixer_item_hand_14",
            "emoji_mixer_item_hand_15",
            "emoji_mixer_item_hand_16",
            
            "emoji_mixer_item_hand_17",
            "emoji_mixer_item_hand_18",
            "emoji_mixer_item_hand_19",
            "emoji_mixer_item_hand_20",
            
            "emoji_mixer_item_hand_1",
            "emoji_mixer_item_hand_2",
            "emoji_mixer_item_hand_3",
            "emoji_mixer_item_hand_4",
            
            "emoji_mixer_item_hand_5",
            "emoji_mixer_item_hand_6",
            "emoji_mixer_item_hand_7",
            "emoji_mixer_item_hand_8",
            
            "emoji_mixer_item_hand_9",
            "emoji_mixer_item_hand_10",
            "emoji_mixer_item_hand_11",
            "emoji_mixer_item_hand_12",
            
            "emoji_mixer_item_hand_5",
            "emoji_mixer_item_hand_6",
            "emoji_mixer_item_hand_7",
            "emoji_mixer_item_hand_8",
            
            "emoji_mixer_item_hand_9",
            "emoji_mixer_item_hand_10",
            "emoji_mixer_item_hand_11",
            "emoji_mixer_item_hand_12",
            ]
        }
    """.trimIndent()
    val emoji2Json = """
        {
            "face": [
            "emoji_mixer_item_foot_1",
            "emoji_mixer_item_foot_2",
            "emoji_mixer_item_foot_3",
            "emoji_mixer_item_foot_4",
            "emoji_mixer_item_foot_5",
            "emoji_mixer_item_foot_6",
            "emoji_mixer_item_foot_7",
            "emoji_mixer_item_foot_8",
            "emoji_mixer_item_foot_9",
            "emoji_mixer_item_foot_10",
            "emoji_mixer_item_foot_11",
            "emoji_mixer_item_foot_12",
            "emoji_mixer_item_foot_13",
            "emoji_mixer_item_foot_14",
            "emoji_mixer_item_foot_15",
            "emoji_mixer_item_foot_16",
            "emoji_mixer_item_foot_17",
            "emoji_mixer_item_foot_18",
            "emoji_mixer_item_foot_19",
            "emoji_mixer_item_foot_20",
            "emoji_mixer_item_foot_21",
            "emoji_mixer_item_foot_22",
            "emoji_mixer_item_foot_23",
            "emoji_mixer_item_foot_24",
            "emoji_mixer_item_foot_25",
            "emoji_mixer_item_foot_26",
            "emoji_mixer_item_foot_27",
            "emoji_mixer_item_foot_28"
            ],
            "eye": [
           
            ],
            "mouth": [
          
            ],
            "hand": [
            ]
        }
    """.trimIndent()


    val emoji3Json = """
        {
            "face": [
            "emoji_mixer_item_fruits_1",
            "emoji_mixer_item_fruits_2",
            "emoji_mixer_item_fruits_3",
            "emoji_mixer_item_fruits_4",
            "emoji_mixer_item_fruits_5",
            "emoji_mixer_item_fruits_6",
            "emoji_mixer_item_fruits_7",
            "emoji_mixer_item_fruits_8",
            "emoji_mixer_item_fruits_9",
            "emoji_mixer_item_fruits_10",
            "emoji_mixer_item_fruits_11",
            "emoji_mixer_item_fruits_12",
            "emoji_mixer_item_fruits_13",
            "emoji_mixer_item_fruits_14",
            "emoji_mixer_item_fruits_15",
            "emoji_mixer_item_fruits_16",
            "emoji_mixer_item_fruits_17",
            "emoji_mixer_item_fruits_18",
            "emoji_mixer_item_fruits_19",
            "emoji_mixer_item_fruits_20",
            "emoji_mixer_item_fruits_21",
            "emoji_mixer_item_fruits_22",
            "emoji_mixer_item_fruits_23",
            "emoji_mixer_item_fruits_24"
            ],
            "eye": [
           
            ],
            "mouth": [
          
            ],
            "hand": [
            ]
        }
    """.trimIndent()

    val emoji4Json = """
        {
            "face": [
            "emoji_mixer_item_animal_1",
            "emoji_mixer_item_animal_2",
            "emoji_mixer_item_animal_3",
            "emoji_mixer_item_animal_4",
            "emoji_mixer_item_animal_5",
            "emoji_mixer_item_animal_6",
            "emoji_mixer_item_animal_7",
            "emoji_mixer_item_animal_8",
            "emoji_mixer_item_animal_9",
            "emoji_mixer_item_animal_10",
            "emoji_mixer_item_animal_11",
            "emoji_mixer_item_animal_12",
            "emoji_mixer_item_animal_13",
            "emoji_mixer_item_animal_14",
            "emoji_mixer_item_animal_15",
            "emoji_mixer_item_animal_16",
            "emoji_mixer_item_animal_17",
            "emoji_mixer_item_animal_18",
            "emoji_mixer_item_animal_19",
            "emoji_mixer_item_animal_20",
            "emoji_mixer_item_animal_21",
            "emoji_mixer_item_animal_22",
            "emoji_mixer_item_animal_23",
            "emoji_mixer_item_animal_24"
            ],
            "eye": [
           
            ],
            "mouth": [
          
            ],
            "hand": [
            ]
        }
    """.trimIndent()


    val emoji5Json = """
        {
            "face": [
            "emoji_mixer_item_astn_1",
            "emoji_mixer_item_astn_2",
            "emoji_mixer_item_astn_3",
            "emoji_mixer_item_astn_4",
            "emoji_mixer_item_astn_5",
            "emoji_mixer_item_astn_6",
            "emoji_mixer_item_astn_7",
            "emoji_mixer_item_astn_8",
            "emoji_mixer_item_astn_9",
            "emoji_mixer_item_astn_10",
            "emoji_mixer_item_astn_11",
            "emoji_mixer_item_astn_12",
            "emoji_mixer_item_astn_13",
            "emoji_mixer_item_astn_14",
            "emoji_mixer_item_astn_15",
            "emoji_mixer_item_astn_16",
            "emoji_mixer_item_astn_17",
            "emoji_mixer_item_astn_18",
            "emoji_mixer_item_astn_19",
            "emoji_mixer_item_astn_20",
            "emoji_mixer_item_astn_other_16"
            ],
            "eye": [
           
            ],
            "mouth": [
          
            ],
            "hand": [
            ]
        }
    """.trimIndent()

    val emoji6Json = """
        {
            "face": [
            "emoji_mixer_item_flower_1",
            "emoji_mixer_item_flower_2",
            "emoji_mixer_item_flower_3",
            "emoji_mixer_item_flower_4",
            "emoji_mixer_item_flower_5",
            "emoji_mixer_item_flower_6",
            "emoji_mixer_item_flower_7",
            "emoji_mixer_item_flower_8",
            "emoji_mixer_item_flower_9",
            "emoji_mixer_item_flower_10",
            "emoji_mixer_item_flower_11",
            "emoji_mixer_item_flower_12",
            "emoji_mixer_item_flower_13",
            "emoji_mixer_item_flower_14",
            "emoji_mixer_item_flower_15",
            "emoji_mixer_item_flower_16",
            "emoji_mixer_item_flower_17",
            "emoji_mixer_item_flower_18",
            "emoji_mixer_item_flower_19",
            "emoji_mixer_item_flower_20",
            "emoji_mixer_item_flower_other_1",
            "emoji_mixer_item_flower_other_2",
            "emoji_mixer_item_flower_other_3",
            "emoji_mixer_item_flower_other_4",
            "emoji_mixer_item_flower_other_5",
            "emoji_mixer_item_flower_other_6",
            "emoji_mixer_item_flower_other_7",
            "emoji_mixer_item_flower_other_8",
            "emoji_mixer_item_flower_other_9",
            "emoji_mixer_item_flower_other_10",
            "emoji_mixer_item_flower_other_11",
            "emoji_mixer_item_flower_other_12",
            "emoji_mixer_item_flower_other_13",
            "emoji_mixer_item_flower_other_14",
            "emoji_mixer_item_flower_other_15",
            "emoji_mixer_item_flower_other_16",
            "emoji_mixer_item_flower_other_17"
            ],
            "eye": [
           
            ],
            "mouth": [
          
            ],
            "hand": [
            ]
        }
    """.trimIndent()


    val emoji7Json = """
        {
            "face": [
           "emoji_mixer_item_other_1",
"emoji_mixer_item_other_2",
"emoji_mixer_item_other_3",
"emoji_mixer_item_other_4",
"emoji_mixer_item_other_5",
"emoji_mixer_item_other_6",
"emoji_mixer_item_other_7",
"emoji_mixer_item_other_8",
"emoji_mixer_item_other_9",
"emoji_mixer_item_other_10",
"emoji_mixer_item_other_11",
"emoji_mixer_item_other_12",
"emoji_mixer_item_other_13",
"emoji_mixer_item_other_14",
"emoji_mixer_item_other_15",
"emoji_mixer_item_other_16",
"emoji_mixer_item_other_17",
"emoji_mixer_item_other_18",
"emoji_mixer_item_other_19",
"emoji_mixer_item_other_20",
"emoji_mixer_item_other_21",
"emoji_mixer_item_other_22",
"emoji_mixer_item_other_23",
"emoji_mixer_item_other_24",
"emoji_mixer_item_other_25",
"emoji_mixer_item_other_26",
"emoji_mixer_item_other_27",
"emoji_mixer_item_other_28",
"emoji_mixer_item_other_other_16"
            ],
            "eye": [
           
            ],
            "mouth": [
          
            ],
            "hand": [
            ]
        }
    """.trimIndent()


    fun getImageData(imageName: String): Int? {
        return when (imageName) {
            "emoji_mixer_item_eye_1" -> R.drawable.emoji_mixer_item_eye_1
            "emoji_mixer_item_eye_2" -> R.drawable.emoji_mixer_item_eye_2
            "emoji_mixer_item_eye_3" -> R.drawable.emoji_mixer_item_eye_3
            "emoji_mixer_item_eye_4" -> R.drawable.emoji_mixer_item_eye_4
            "emoji_mixer_item_eye_5" -> R.drawable.emoji_mixer_item_eye_5
            "emoji_mixer_item_eye_6" -> R.drawable.emoji_mixer_item_eye_6
            "emoji_mixer_item_eye_7" -> R.drawable.emoji_mixer_item_eye_7
            "emoji_mixer_item_eye_8" -> R.drawable.emoji_mixer_item_eye_8
            "emoji_mixer_item_eye_9" -> R.drawable.emoji_mixer_item_eye_9
            "emoji_mixer_item_eye_10" -> R.drawable.emoji_mixer_item_eye_10
            "emoji_mixer_item_eye_11" -> R.drawable.emoji_mixer_item_eye_11
            "emoji_mixer_item_eye_12" -> R.drawable.emoji_mixer_item_eye_12
            "emoji_mixer_item_eye_13" -> R.drawable.emoji_mixer_item_eye_13
            "emoji_mixer_item_eye_14" -> R.drawable.emoji_mixer_item_eye_14
            "emoji_mixer_item_eye_15" -> R.drawable.emoji_mixer_item_eye_15
            "emoji_mixer_item_eye_16" -> R.drawable.emoji_mixer_item_eye_16
            "emoji_mixer_item_eye_17" -> R.drawable.emoji_mixer_item_eye_17
            "emoji_mixer_item_eye_18" -> R.drawable.emoji_mixer_item_eye_18
            "emoji_mixer_item_eye_19" -> R.drawable.emoji_mixer_item_eye_19
            "emoji_mixer_item_eye_20" -> R.drawable.emoji_mixer_item_eye_20
            "emoji_mixer_item_eye_21" -> R.drawable.emoji_mixer_item_eye_21
            "emoji_mixer_item_eye_22" -> R.drawable.emoji_mixer_item_eye_22
            "emoji_mixer_item_eye_23" -> R.drawable.emoji_mixer_item_eye_23
            "emoji_mixer_item_eye_24" -> R.drawable.emoji_mixer_item_eye_24
            "emoji_mixer_item_eye_25" -> R.drawable.emoji_mixer_item_eye_25
            "emoji_mixer_item_eye_26" -> R.drawable.emoji_mixer_item_eye_26
            "emoji_mixer_item_eye_27" -> R.drawable.emoji_mixer_item_eye_27
            "emoji_mixer_item_eye_28" -> R.drawable.emoji_mixer_item_eye_28
            "emoji_mixer_item_eye_29" -> R.drawable.emoji_mixer_item_eye_29
            "emoji_mixer_item_eye_30" -> R.drawable.emoji_mixer_item_eye_30
            "emoji_mixer_item_face_1" -> R.drawable.emoji_mixer_item_face_1
            "emoji_mixer_item_face_2" -> R.drawable.emoji_mixer_item_face_2
            "emoji_mixer_item_face_3" -> R.drawable.emoji_mixer_item_face_3
            "emoji_mixer_item_face_4" -> R.drawable.emoji_mixer_item_face_4
            "emoji_mixer_item_face_5" -> R.drawable.emoji_mixer_item_face_5
            "emoji_mixer_item_face_6" -> R.drawable.emoji_mixer_item_face_6
            "emoji_mixer_item_foot_1" -> R.drawable.emoji_mixer_item_foot_1
            "emoji_mixer_item_foot_2" -> R.drawable.emoji_mixer_item_foot_2
            "emoji_mixer_item_foot_3" -> R.drawable.emoji_mixer_item_foot_3
            "emoji_mixer_item_foot_4" -> R.drawable.emoji_mixer_item_foot_4
            "emoji_mixer_item_foot_5" -> R.drawable.emoji_mixer_item_foot_5
            "emoji_mixer_item_foot_6" -> R.drawable.emoji_mixer_item_foot_6
            "emoji_mixer_item_foot_7" -> R.drawable.emoji_mixer_item_foot_7
            "emoji_mixer_item_foot_8" -> R.drawable.emoji_mixer_item_foot_8
            "emoji_mixer_item_foot_9" -> R.drawable.emoji_mixer_item_foot_9
            "emoji_mixer_item_foot_10" -> R.drawable.emoji_mixer_item_foot_10
            "emoji_mixer_item_foot_11" -> R.drawable.emoji_mixer_item_foot_11
            "emoji_mixer_item_foot_12" -> R.drawable.emoji_mixer_item_foot_12
            "emoji_mixer_item_foot_13" -> R.drawable.emoji_mixer_item_foot_13
            "emoji_mixer_item_foot_14" -> R.drawable.emoji_mixer_item_foot_14
            "emoji_mixer_item_foot_15" -> R.drawable.emoji_mixer_item_foot_15
            "emoji_mixer_item_foot_16" -> R.drawable.emoji_mixer_item_foot_16
            "emoji_mixer_item_foot_17" -> R.drawable.emoji_mixer_item_foot_17
            "emoji_mixer_item_foot_18" -> R.drawable.emoji_mixer_item_foot_18
            "emoji_mixer_item_foot_19" -> R.drawable.emoji_mixer_item_foot_19
            "emoji_mixer_item_foot_20" -> R.drawable.emoji_mixer_item_foot_20
            "emoji_mixer_item_foot_21" -> R.drawable.emoji_mixer_item_foot_21
            "emoji_mixer_item_foot_22" -> R.drawable.emoji_mixer_item_foot_22
            "emoji_mixer_item_foot_23" -> R.drawable.emoji_mixer_item_foot_23
            "emoji_mixer_item_foot_24" -> R.drawable.emoji_mixer_item_foot_24
            "emoji_mixer_item_foot_25" -> R.drawable.emoji_mixer_item_foot_25
            "emoji_mixer_item_foot_26" -> R.drawable.emoji_mixer_item_foot_26
            "emoji_mixer_item_foot_27" -> R.drawable.emoji_mixer_item_foot_27
            "emoji_mixer_item_foot_28" -> R.drawable.emoji_mixer_item_foot_28
            "emoji_mixer_item_hand_1" -> R.drawable.emoji_mixer_item_hand_1
            "emoji_mixer_item_hand_2" -> R.drawable.emoji_mixer_item_hand_2
            "emoji_mixer_item_hand_3" -> R.drawable.emoji_mixer_item_hand_3
            "emoji_mixer_item_hand_4" -> R.drawable.emoji_mixer_item_hand_4
            "emoji_mixer_item_hand_5" -> R.drawable.emoji_mixer_item_hand_5
            "emoji_mixer_item_hand_6" -> R.drawable.emoji_mixer_item_hand_6
            "emoji_mixer_item_hand_7" -> R.drawable.emoji_mixer_item_hand_7
            "emoji_mixer_item_hand_8" -> R.drawable.emoji_mixer_item_hand_8
            "emoji_mixer_item_hand_9" -> R.drawable.emoji_mixer_item_hand_9
            "emoji_mixer_item_hand_10" -> R.drawable.emoji_mixer_item_hand_10
            "emoji_mixer_item_hand_11" -> R.drawable.emoji_mixer_item_hand_11
            "emoji_mixer_item_hand_12" -> R.drawable.emoji_mixer_item_hand_12
            "emoji_mixer_item_hand_13" -> R.drawable.emoji_mixer_item_hand_13
            "emoji_mixer_item_hand_14" -> R.drawable.emoji_mixer_item_hand_14
            "emoji_mixer_item_hand_15" -> R.drawable.emoji_mixer_item_hand_15
            "emoji_mixer_item_hand_16" -> R.drawable.emoji_mixer_item_hand_16
            "emoji_mixer_item_hand_17" -> R.drawable.emoji_mixer_item_hand_17
            "emoji_mixer_item_hand_18" -> R.drawable.emoji_mixer_item_hand_18
            "emoji_mixer_item_hand_19" -> R.drawable.emoji_mixer_item_hand_19
            "emoji_mixer_item_hand_20" -> R.drawable.emoji_mixer_item_hand_20
            "emoji_mixer_item_mouth_1" -> R.drawable.emoji_mixer_item_mouth_1
            "emoji_mixer_item_mouth_2" -> R.drawable.emoji_mixer_item_mouth_2
            "emoji_mixer_item_mouth_3" -> R.drawable.emoji_mixer_item_mouth_3
            "emoji_mixer_item_mouth_4" -> R.drawable.emoji_mixer_item_mouth_4
            "emoji_mixer_item_mouth_5" -> R.drawable.emoji_mixer_item_mouth_5
            "emoji_mixer_item_mouth_6" -> R.drawable.emoji_mixer_item_mouth_6
            "emoji_mixer_item_mouth_7" -> R.drawable.emoji_mixer_item_mouth_7
            "emoji_mixer_item_mouth_8" -> R.drawable.emoji_mixer_item_mouth_8
            "emoji_mixer_item_mouth_9" -> R.drawable.emoji_mixer_item_mouth_9
            "emoji_mixer_item_mouth_10" -> R.drawable.emoji_mixer_item_mouth_10
            "emoji_mixer_item_mouth_11" -> R.drawable.emoji_mixer_item_mouth_11
            "emoji_mixer_item_mouth_12" -> R.drawable.emoji_mixer_item_mouth_12
            "emoji_mixer_item_mouth_13" -> R.drawable.emoji_mixer_item_mouth_13
            "emoji_mixer_item_mouth_14" -> R.drawable.emoji_mixer_item_mouth_14
            "emoji_mixer_item_mouth_15" -> R.drawable.emoji_mixer_item_mouth_15
            "emoji_mixer_item_mouth_16" -> R.drawable.emoji_mixer_item_mouth_16
            "emoji_mixer_item_mouth_17" -> R.drawable.emoji_mixer_item_mouth_17
            "emoji_mixer_item_mouth_18" -> R.drawable.emoji_mixer_item_mouth_18
            "emoji_mixer_item_mouth_19" -> R.drawable.emoji_mixer_item_mouth_19
            "emoji_mixer_item_mouth_20" -> R.drawable.emoji_mixer_item_mouth_20
            "emoji_mixer_item_mouth_21" -> R.drawable.emoji_mixer_item_mouth_21
            "emoji_mixer_item_mouth_22" -> R.drawable.emoji_mixer_item_mouth_22
            "emoji_mixer_item_mouth_23" -> R.drawable.emoji_mixer_item_mouth_23
            "emoji_mixer_item_mouth_24" -> R.drawable.emoji_mixer_item_mouth_24
            "emoji_mixer_item_mouth_25" -> R.drawable.emoji_mixer_item_mouth_25
            "emoji_mixer_item_mouth_26" -> R.drawable.emoji_mixer_item_mouth_26
            "emoji_mixer_item_mouth_27" -> R.drawable.emoji_mixer_item_mouth_27
            "emoji_mixer_item_mouth_28" -> R.drawable.emoji_mixer_item_mouth_28
            "emoji_mixer_item_mouth_29" -> R.drawable.emoji_mixer_item_mouth_29
            "emoji_mixer_item_mouth_30" -> R.drawable.emoji_mixer_item_mouth_30
            "emoji_mixer_item_mouth_31" -> R.drawable.emoji_mixer_item_mouth_31
            "emoji_mixer_item_mouth_32" -> R.drawable.emoji_mixer_item_mouth_32
            "emoji_mixer_item_mouth_33" -> R.drawable.emoji_mixer_item_mouth_33
            "emoji_mixer_item_mouth_34" -> R.drawable.emoji_mixer_item_mouth_34
            "emoji_mixer_item_mouth_35" -> R.drawable.emoji_mixer_item_mouth_35
            "emoji_mixer_item_mouth_36" -> R.drawable.emoji_mixer_item_mouth_36
            "main_item_icons_animal1" -> R.drawable.main_item_icons_animal1
            "main_item_icons_animal2" -> R.drawable.main_item_icons_animal2
            "main_item_icons_animal3" -> R.drawable.main_item_icons_animal3
            "main_item_icons_animal4" -> R.drawable.main_item_icons_animal4
            "main_item_icons_animal5" -> R.drawable.main_item_icons_animal5
            "main_item_icons_animal6" -> R.drawable.main_item_icons_animal6
            "main_item_icons_animal7" -> R.drawable.main_item_icons_animal7
            "main_item_icons_animal8" -> R.drawable.main_item_icons_animal8
            "main_item_icons_animal9" -> R.drawable.main_item_icons_animal9
            "main_item_icons_cry1" -> R.drawable.main_item_icons_cry1
            "main_item_icons_cry2" -> R.drawable.main_item_icons_cry2
            "main_item_icons_cry3" -> R.drawable.main_item_icons_cry3
            "main_item_icons_cry4" -> R.drawable.main_item_icons_cry4
            "main_item_icons_cry5" -> R.drawable.main_item_icons_cry5
            else -> null
        }
    }
}
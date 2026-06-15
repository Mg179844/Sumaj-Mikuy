package com.familytrack.sumajmikuy.data.local

object CloudinaryConfig {
    const val CLOUD_NAME = "dmmbxovvu"
    const val BASE_URL = "https://res.cloudinary.com/$CLOUD_NAME/image/upload/"

    fun buildUrl(publicId: String, transformation: String = ""): String {
        return if (transformation.isEmpty()) {
            "$BASE_URL$publicId"
        } else {
            "${BASE_URL}${transformation}/$publicId"
        }
    }

    fun buildUrl(publicId: String, transformations: List<String>): String {
        val transformationPath = transformations.joinToString(",") { it }
        return "${BASE_URL}${transformationPath}/$publicId"
    }
}

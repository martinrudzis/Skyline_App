package com.example.skyline.mockdata

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.Test
import java.io.File
import java.io.InputStream
import java.nio.charset.Charset

@Test
fun RunMockWebServer() {
    val mockServer = MockWebServer()
    mockServer.start()

    val inputStream: InputStream = File("ExampleOpenskyApiResponse.json").inputStream()
    val source = inputStream.source().buffer()
    val mockResponse = MockResponse()
        .setResponseCode(200)
        .setBody(source.readString(Charsets.UTF_8))
    mockServer.enqueue(mockResponse)

    val jsonStream =
    mockRepsonse.setBody(

    )
}
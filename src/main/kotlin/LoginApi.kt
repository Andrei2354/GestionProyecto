import io.ktor.client.utils.EmptyContent.contentType
import io.ktor.http.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun apiLogIn(usuario:String, password: String, OnSuccessrResponse: (User) -> Unit){
    val url = "http://127.0.0.1:500/gestor/login"
    CoroutineScope(Dispatchers.IO).launch {
        val response = httpClient.post(url){
            contentType(ContentType.Application.Json)
            setBody(LoginRequest(usuario, sha512(password)))
        }
        if (respone.status == HttpStatusCode.Ok){
            val user = response.body<User>()
            onSuccesResponse(user)
        } else {
            println("Error: ${response.status}, Body: ${response.bodyAsText()}")
        }
    }
}
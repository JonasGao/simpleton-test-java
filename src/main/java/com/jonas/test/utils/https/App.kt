import org.apache.http.impl.client.HttpClients
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory

fun main(args: Array<String>) {
    val sslContext = SSLContext.getInstance("SSL", "SunJSSE")

    HttpClients.custom().setSSLSocketFactory()
}
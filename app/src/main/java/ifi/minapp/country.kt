
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import kotlinx.coroutines.runBlocking

class country(
    val name: String,
    val areal: String,
    val fact1: String,
    val fact2: String) {

    fun name() : String{
        return name
    }
    fun areal() : String{
        return areal
    }

    fun funfact1() : String{
        return fact1
    }

    fun funfact2() : String{
        return fact2
    }

}
fun APIcalls(land : String) = runBlocking{

    val apiKey = "ESP/BI/0Q1w5tyZYrfBbJg==87MrnOPMGd6uMVZl"


    // Set the API key in FuelManager headers
    FuelManager.instance.baseHeaders = mapOf("X-Api-Key" to apiKey)

    "https://api.api-ninjas.com/v1/country?name=$land".httpGet().responseString { _, _, result ->

        when (result) {

            is Result.Success -> {

                val data = result.get()
                println(data)

            }
            is Result.Failure -> {

                val error = result.getException()
                println("Error: $error")
            }
        }
    }
}
fun main(){
    APIcalls("United States")
}


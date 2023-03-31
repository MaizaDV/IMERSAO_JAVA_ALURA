import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // 1° fazer uma conexão HTTP e buscar os top 250 filmes do IMDB;
        
        // endereço da API ====>
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        // identificação única do recurso usado, para poder usar a requisição ====>
        URI endereco = URI.create(url);

        // cliente ====>
        var client = HttpClient.newHttpClient();

        // requisição ====>
        var request = HttpRequest.newBuilder(endereco).GET().build();
        
        // recurso para ler o retorno da requisição ====>
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        // pega o 'corpo' da resposta da requisição ====>
        String body = response.body();

        // 2° extrair só os dados que interessam (titulo, poster, classificação);
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        // exibe a requisição ====>
        System.out.println(listaDeFilmes.size());

        // 3° exibir e manipular os dados;
    }
}

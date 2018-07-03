package com.github.dieogoliber.openproject.trelloimporter.integration.trello;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.github.dieogoliber.openproject.trelloimporter.integration.trello.model.Board;
import com.github.dieogoliber.openproject.trelloimporter.integration.trello.model.Card;
import com.github.dieogoliber.openproject.trelloimporter.integration.trello.model.Label;
import com.github.dieogoliber.openproject.trelloimporter.integration.trello.model.Member;
import com.github.dieogoliber.openproject.trelloimporter.integration.trello.model.TrelloList;
import com.github.dieogoliber.openproject.trelloimporter.model.Account;

@Component
public class TrelloClient {

	private static final Logger LOGGER = LoggerFactory.getLogger(TrelloClient.class);

	private static final String TRELLO_BASE_URL = "https://api.trello.com/1";

	private TrelloApiInfo apiInfo;

	private RestTemplate restTemplate;

	@Autowired
	public TrelloClient(@Qualifier("trelloRestTemplate") RestTemplate restTemplate, TrelloApiInfo apiInfo) {
		this.restTemplate = restTemplate;
		this.apiInfo = apiInfo;
	}

	public Account getCurrentUser(String token) {

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(TRELLO_BASE_URL).path("/members/me")
				.queryParam("key", apiInfo.getApiKey()).queryParam("token", token);

		String uri = builder.build().toUriString();

		LOGGER.info("Target URI {}", uri);

		ResponseEntity<Account> response = this.restTemplate.exchange(uri, HttpMethod.GET, null, Account.class);
		return response.getBody();
	}

	public List<Board> getBoardsFromCurrentMember(String token) {

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(TRELLO_BASE_URL).path("/members/me/boards")
				.queryParam("key", apiInfo.getApiKey()).queryParam("token", token);

		String uri = builder.build().toUriString();

		LOGGER.info("Target URI {}", uri);

		ResponseEntity<List<Board>> response = this.restTemplate.exchange(uri, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Board>>() {
				});
		return response.getBody();
	}

	public List<TrelloList> getListsFromBoard(String token, Board board) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(TRELLO_BASE_URL).path("/boards/{boardId}/lists")
				.queryParam("key", apiInfo.getApiKey()).queryParam("token", token);

		Map<String, String> params = new HashMap<>();
		params.put("boardId", board.getId());
		
		String uri = builder.build().expand(params).toUriString();

		LOGGER.info("Target URI {}", uri);

		ResponseEntity<List<TrelloList>> response = this.restTemplate.exchange(uri, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<TrelloList>>() {
				});
		return response.getBody();
	}
	
	public List<Card> getCardsFromList(String token, TrelloList list) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(TRELLO_BASE_URL).path("/lists/{listId}/cards")
				.queryParam("key", apiInfo.getApiKey()).queryParam("token", token);

		Map<String, String> params = new HashMap<>();
		params.put("listId", list.getId());
		
		String uri = builder.build().expand(params).toUriString();

		LOGGER.info("Target URI {}", uri);

		ResponseEntity<List<Card>> response = this.restTemplate.exchange(uri, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Card>>() {
				});
		return response.getBody();
	}
	
	public TrelloList getListFromCard(String token, Card card) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(TRELLO_BASE_URL).path("/cards/{cardId}/list")
				.queryParam("key", apiInfo.getApiKey()).queryParam("token", token);

		Map<String, String> params = new HashMap<>();
		params.put("cardId", card.getId());
		
		String uri = builder.build().expand(params).toUriString();

		LOGGER.info("Target URI {}", uri);

		ResponseEntity<TrelloList> response = this.restTemplate.exchange(uri, HttpMethod.GET, null,
				TrelloList.class);
		return response.getBody();
	}
	
	public List<Member> getMembersFromCard(String token, Card card) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(TRELLO_BASE_URL).path("/cards/{cardId}/members")
				.queryParam("key", apiInfo.getApiKey()).queryParam("token", token);

		Map<String, String> params = new HashMap<>();
		params.put("cardId", card.getId());
		
		String uri = builder.build().expand(params).toUriString();

		LOGGER.info("Target URI {}", uri);

		ResponseEntity<List<Member>> response = this.restTemplate.exchange(uri, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Member>>() {
		});
		return response.getBody();
	}
	
	public List<Member> getMembersFromBoard(String token, Board board) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(TRELLO_BASE_URL).path("/boards/{id}/members")
				.queryParam("key", apiInfo.getApiKey()).queryParam("token", token);

		Map<String, String> params = new HashMap<>();
		params.put("id", board.getId());
		
		String uri = builder.build().expand(params).toUriString();

		LOGGER.info("Target URI {}", uri);

		ResponseEntity<List<Member>> response = this.restTemplate.exchange(uri, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Member>>() {
		});
		return response.getBody();
	}
	
	public List<Label> getLabelsFromBoard(String token, Board board) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(TRELLO_BASE_URL).path("/boards/{id}/labels")
				.queryParam("key", apiInfo.getApiKey()).queryParam("token", token);

		Map<String, String> params = new HashMap<>();
		params.put("id", board.getId());
		
		String uri = builder.build().expand(params).toUriString();

		LOGGER.info("Target URI {}", uri);

		ResponseEntity<List<Label>> response = this.restTemplate.exchange(uri, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Label>>() {
		});
		return response.getBody();
	}
	
	public static void main(String[] args) {
		String token = "45b85dbca849f4ce84034503fa92cb751ed0aacf863e8883a599f43d37c57064";
		
		TrelloClient client = new TrelloClient(new RestTemplateBuilder().build(), 
				new TrelloApiInfo("0bcb1b5f2437cfd420c9676fe756377b", null));
		
		List<Board> boards = client.getBoardsFromCurrentMember(token);
		
		for (Board board: boards) {
			if (board.getName().equals("DIAS-PORTFOLIO-OUTROS")) {
				for (Member member : client.getMembersFromBoard(token, board)) {
					System.out.printf("Board Member: %s\n", member.getUsername());
				}
				for (Label label : client.getLabelsFromBoard(token, board)) {
					System.out.printf("Board Label: %s,%s\n", label.getName(), label.getColor());
				}
				List<TrelloList> lists = client.getListsFromBoard(token, board);
				for (TrelloList list : lists) {
					if (list.getName().toLowerCase().contains("andamento")) {
						
						for (Card card : client.getCardsFromList(token, list)) {
							System.out.println("##############################");
							System.out.printf("Card: %s\n", card.getName());
							for (Label label : card.getLabels()) {
								System.out.printf("Label (%s,%s)\n", label.getName(), label.getColor());
							}
							List<Member> members = client.getMembersFromCard(token, card);
							for (Member member: members) {
								System.out.printf("Member %s\n", member.getUsername());
							}
						}
					}
				}
			}
		}
	}

}

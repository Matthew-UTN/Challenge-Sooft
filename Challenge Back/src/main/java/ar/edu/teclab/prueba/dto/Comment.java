package ar.edu.teclab.prueba.dto;

/*
 * "id": 1159780949072,
            "type": "Comment",
            "author_id": 400041509731,
            "body": "Esto es un body de prueba",
            "html_body": "<div class=\"zd-comment\" dir=\"auto\"><p dir=\"auto\">Esto es un body de prueba</p></div>",
            "plain_body": "Esto es un body de prueba",
            "public": true,
            "attachments": [],
            "audit_id": 1159780948432,
            "via": {
                "channel": "api",
                "source": {
                    "from": {},
                    "to": {},
                    "rel": null
                }
            },
            "created_at": "2020-08-12T15:01:15Z",
            "metadata": {
                "system": {
                    "client": "Java/1.8.0_265",
                    "ip_address": "190.224.138.51",
                    "location": "San Miguel de TucumÃ¡n, T, Argentina",
                    "latitude": -26.816,
                    "longitude": -65.2154
                },
                "custom": {}
            }
        
 * */

public class Comment {
	private long id;
    private String type;
    private Long author_id;
    private String body;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(Long author_id) {
		this.author_id = author_id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

	public Comment(long id, String type, Long author_id, String body) {
		super();
		this.id = id;
		this.type = type;
		this.author_id = author_id;
		this.body = body;
	}
	public Comment() {
		super();
	}
    
    
}

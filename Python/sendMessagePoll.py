import requests
import json

# Substitua pelas suas credenciais
api_key = 'GLOBAL_API_KEY'
session_id = 'SESSION_ID'
phone_number = '557183196364'

# Crie os dados da requisição
data = {
    "chatId": f"{phone_number}@c.us",
    "contentType": "Poll",
    "content": {
        "pollName": "Cats or Dogs?",
        "pollOptions": [
            "Cats",
            "Dogs"
        ],
        "options": {
            "allowMultipleAnswers": True
        }
    }
}

# Crie os cabeçalhos da requisição
headers = {
    'accept': '*/*',
    'x-api-key': api_key,
    'Content-Type': 'application/json'
}

# Faça a requisição POST
url = f"https://zip-zop.site/client/sendMessage/{session_id}"

try:
    response = requests.post(url, headers=headers, data=json.dumps(data))
    response.raise_for_status()  # Levanta um erro para códigos de status HTTP 4xx/5xx
    print("Response:", response.json())
except requests.exceptions.RequestException as e:
    print("Error:", e)

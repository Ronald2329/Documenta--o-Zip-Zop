const axios = require('axios'); 

// Substitua pelas suas credenciais
const api_key = 'GLOBAL_API_KEY';
const session_id = 'SESSION_ID';
/*PRESTE ATENÇÃO PARA NÃO ERRAR, O FORMATO DO NÚMERO É:
  CÓDIGO POSTAL DO PAÍS + DD + NÚMERO SEM O "9" NA FRENTE.
  ISSO MESMO SEM O "9" NA FRENTE POIS, O WHATSAPP TRANSFORMA
  O NÚMERO EM 8 DÍGITOS E NÃO 9 COMO É O NOVO PADRÃO BRASILEIRO.
  LOGO POR FAVOR UTILIZE OS OITO DÍGITOS E NÃO NOVE DÍGITOS
  COM O "9" NA FRENTE!!!

*/
const phone_number = '557183196364';

// Crie os dados da requisição
const data = {
    "chatId": "557183196364@c.us",
    "contentType": "MessageMediaFromURL",
    "content": "https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=Example"
  };

// Crie os cabeçalhos da requisição
const headers = {
  'accept': '*/*',
  'x-api-key': api_key,
  'Content-Type': 'application/json',
};

// Faça a requisição POST
axios.post(`https://zip-zop.site/client/sendMessage/${session_id}`, data, { headers })
  .then(response => {
    // Imprima a resposta
    console.log(response.data);
  })
  .catch(error => {
    console.error(error);
  });

<?php
// Definir cabeçalhos

$apiKey = "GLOBAL_API_KEY";
$headers = [
    'Accept:*/*',
    'x-api-key:'.$apiKey,
    'Content-Type:application/json',
];

/*PRESTE ATENÇÃO PARA NÃO ERRAR, O FORMATO DO NÚMERO É:
  CÓDIGO POSTAL DO PAÍS + DD + NÚMERO SEM O "9" NA FRENTE.
  ISSO MESMO SEM O "9" NA FRENTE POIS, O WHATSAPP TRANSFORMA
  O NÚMERO EM 8 DÍGITOS E NÃO 9 COMO É O NOVO PADRÃO BRASILEIRO.
  LOGO POR FAVOR UTILIZE OS OITO DÍGITOS E NÃO NOVE DÍGITOS
  COM O "9" NA FRENTE!!!

*/
$number = 557599896182; 

// Definir corpo da solicitação
$body = [
    "chatId" => "557183196364@c.us",
    "contentType" => "MessageMedia",
    "content" => [
      "mimetype" => "image/jpeg",
      "data" => "iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNk+A8AAQUBAScY42YAAAAASUVORK5CYII=",
      "filename" => "image.jpg"
    ]
  ];

$sessionId = 'SESSION_ID';

$ch = curl_init('https://zip-zop.site/client/sendMessage/'.$sessionId);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_POST, true);
curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($body));
curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);

// Executar!
$response = curl_exec($ch);

echo json_encode($response);

// Fechar a conexão e liberar recursos
curl_close($ch);

// Fazer algo com a resposta
var_dump($response);

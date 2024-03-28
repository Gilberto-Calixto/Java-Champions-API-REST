package com.dev.santander.domain.model;

//record: contém uma abstração referente as colunas do script sql no diretório domain-> model
public record Champion(
    long id,
    String name,
    String role,
    String lore,
    String imgUrl
) {

    public String generateContextByQuestion(String question){
        return """
        Pergunta: %s
        Nome: %s
        Função: %s  
        Lore(História): %s    
        """.formatted(question,this.name, this.role, this.lore);
    }
}

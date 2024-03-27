package com.dev.santander.domain.model;

//record: contém uma abstração referente as colunas do script sql no diretório domain-> model
public record Champions(
    long id,
    String name,
    String role,
    String lore,
    String imgUrl
) {
}

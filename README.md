## Опис
REST інтерфейс для роботи з Neo4j.
Можна використовувати з бажаним ETL інструментом.

Дублює функції neosemantics.

Додає можливість завантаити файл напряму.

## Призначення
Синхронізаця RDF файлів з базою Neo4j.

## Передумови
- Neo4j з встановленим і проініціалізованим плагіном neosemantics https://github.com/neo4j-labs/neosemantics.

## Функції
- Завантаження RDF файлу
```
PUT /rdf/import/file
PUT /rdf/import/fetch
```
- Додавання і зміна нод, звязків і пропертів через окремі RDF записи
```
PUT /rdf/import/inline
```
- видалення записів

```
DELETE /rdf/delete/inline 
DELETE /rdf/delete/fetch
```

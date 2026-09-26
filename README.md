# QA API Capstone

Capstone курсу QA Mentorship: **5 API-тестів на REST Assured** проти публічного стенду
[JSONPlaceholder](https://jsonplaceholder.typicode.com). Приймання — **зелений прогін GitHub Actions**
у твоєму форку.

## Як працювати

```bash
git clone https://github.com/<твій-логін>/qa-api-capstone.git
cd qa-api-capstone
grep -rn "TODO" src/test/java        # що саме треба реалізувати
# реалізуй ApiClient, поки mvn test не стане зеленим
git push origin main                 # і прикріпи посилання на зелений прогін у курсі
```

## Що перевіряє CI

`mvn -B -q test` на Ubuntu з Java 17: 5 тестів. У скелеті вони **червоні** (методи клієнта
кидають UnsupportedOperationException) — задача зробити прогін зеленим. Якщо щось упало,
у прогоні є артефакт `surefire-reports` з повним текстом помилки.

## Вимоги

- Ніяких URL у тестах: усе в `ApiClient`.
- Перевірки — у тестах; клієнт лише виконує запити й повертає `Response`.
- 404 — це валідна відповідь, не помилка клієнта.

## Ліцензія

MIT. Скелет створено для курсу.

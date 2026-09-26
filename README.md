# QA API Capstone

Capstone курсу QA Mentorship: **5 API-тестів на REST Assured** проти публічних стендів
(httpbin.org та jsonplaceholder.typicode.com). Приймання — **зелений прогін GitHub Actions**
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
кидають UnsupportedOperationException) — твоя задача зробити прогін зеленим.

## Вимоги

- Ніяких URL у тестах: усе в `ApiClient`.
- Перевірки — у тестах, клієнт лише виконує запити й повертає `Response`.
- Тести незалежні; жодних `Thread.sleep`.

## Ліцензія

MIT. Скелет створено для курсу.

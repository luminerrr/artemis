table:
1. books
2. authors
3. genres

1. books
columns:
- id (pkey long)
- title (string)
- author_id (fkey -> authors)
- genre_id (fkey -> genres)

2. authors
columns:
- id (pkey long)
- name (string)
- age (int)
- description (string)

3. genre
columns
- id (pkey long)
- name (string)
- description (string)
<template>
  <v-card>
    <v-card-text>
      <div class="book-card">
        <div class="card-img">
          <v-img :src="book.pictureUrl" />
        </div>
        <div class="card-body">
          <div class="body-text">
            <h5 class="card-title">{{ book.title }}</h5>
            <p class="card-text">{{ book.authors.join(" / ") }}</p>
            <p class="card-text">{{ book.category.join(" / ")}}</p>
          </div>
          <v-btn icon>
            <v-icon>mdi-star</v-icon>
          </v-btn>
          <v-btn>
            本の詳細へ
          </v-btn>
        </div>
        </div>
    </v-card-text>
  </v-card>
</template>

<script>
import Book from "../model/Book"

export default {
  props: {
    book: {
      type: Book,
      required: true
    }
  }
}
</script>

<style scoped>
  .book-card{
    display:flex;
  }
.card-img {
  width: 30%;
  margin-right: 1rem;
}
.card-body {
  display: block;
  flex-direction: column;
}
  .body-text {
    font-size: 3vm;
    text-align: left;
  }
</style>

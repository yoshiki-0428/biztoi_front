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
            <p class="card-text">{{ Author }}</p>
            <p class="card-text">{{ book.category }}</p>
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
import _ from "lodash"
export default {
  props: {
    book: {
      type: Book,
      required: true
    }
  },
  computed: {
    Author() {
      if (!_.isArray(this.book.authors)){
        return console.log("著者が不明です！")
      }
      else if (_.size(this.book.authors) === 1) {
        return this.book.authors[0]
      } else
        return this.book.authors.join()
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
  height: 10%;
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

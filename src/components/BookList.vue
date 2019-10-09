<template>
  <v-card>
    <v-card-text>
      <div class="book-card">
        <div class="card-img">
          <v-img :src="BookData.pictureUrl" />
        </div>
        <div class="card-body">
          <h5 class="card-title">{{ BookData.title }}</h5>
          <p class="card-text">{{ BookData.authors }}</p>
        </div>
        <div>
          <v-btn icon>
            <v-icon>mdi-star</v-icon>
          </v-btn>
          <v-divider class="mx-4"></v-divider>
        </div>
      </div>
    </v-card-text>
  </v-card>
</template>

<script>
export default {
  props: ["BookData"]
};
</script>

<style scoped>
.card-img {
  width: 30%;
  text-align: center;
  margin: 0 auto;
}
.card-body {
  font-size: 3vm;
  text-align: center;
}
</style>

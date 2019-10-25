<template>
  <div>
    <h2>いいね数ランキング</h2>
    <v-carousel
            class="good-rank"
            cycle
            height="300"
            show-arrows-on-hover
    >
      <v-carousel-item
              v-for="(good, i) in goods"
              :key="i"
      >
        <v-sheet
                :color="colors[i]"
                height="100%"
        >
          <v-row
                  class="fill-height"
                  align="center"
                  justify="center"
          >
            <div class="display-2">{{ good }}</div>
          </v-row>
        </v-sheet>
      </v-carousel-item>
    </v-carousel>
  </div>

</template>
<script>
export default {
  data () {
    return {
      colors: [
        'indigo',
        'warning',
        'pink darken-2',
        'red lighten-1',
        'deep-purple accent-4',
      ],
      goods: [
        "Good1",
        "Good2",
        "Good3",
        "Good4",
        "Good5",
      ],
    }
  },
}
</script>

<style scoped>
  .good-rank{
    margin-bottom: 1rem;
  }
</style>


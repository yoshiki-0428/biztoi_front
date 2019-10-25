<template>
  <div>
    <h2>人気ランキング</h2>
    <v-carousel
            class="best-rank"
            cycle
            height="300"
            show-arrows-on-hover
    >
      <v-carousel-item
              v-for="(best, i) in bests"
              :key="i">
        <v-sheet
                :color="colors[i]"
                height="100%">
          <v-row
                  class="fill-height"
                  align="center"
                  justify="center"
          >
            <div class="display-2">{{ best }}</div>
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
      bests: [
        "Best1",
        "Best2",
        "Best3",
        "Best4",
        "Best5",
      ],
    }
  },
}
</script>

<style scoped>
  .best-rank{
    margin-bottom: 1rem;
  }
</style>
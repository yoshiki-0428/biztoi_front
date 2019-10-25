<template>
  <v-container>
    <div @click="getUser">Get User</div>
    <div>{{ userInfo }}</div>
    <best />
    <good-rank />
  </v-container>
</template>

<script>
import Best from "../components/Best"
import GoodRank from "../components/GoodRank"

export default {
  components: {
    Best,
    GoodRank
  },
  data: () => {
    return {
      userInfo: Object
    }
  },
  created() {
    const code = this.$route.query.code
    if (code) {
      this.getToken(code)
    }
  },
  methods: {
    getToken(code) {
      this.$authApi.getTokenCode(code).then(result => {
        localStorage.setItem("idToken", result.data)
        location.href = "/top"
      })
    },
    async getUser() {
      this.userInfo = await this.$usersApi.get().then(result => {
        return result.data
      })
    }
  }
}
</script>

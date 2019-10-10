import { googleApi } from "../plugins/Repository";

export default {
  getBooksTitle(word) {
    return googleApi.get("volumes", {
      params: {
        q: `intitle:${word}`,
        Country: "JP",
        maxResults: 20,
        orderBy: "relevance"
      }
    });
  },
  getBooksAuthor(word) {
    return googleApi.get("volumes", {
      params: {
        q: `inauthors:${word}`,
        Country: "JP",
        maxResults: 20,
        orderBy: "relevance"
      }
    });
  }
};

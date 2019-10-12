import { googleApi } from "../plugins/Repository";

function getResource(searchType, word) {
  if (searchType === "author") {
    return `inauthor:${word}`;
  } else if (searchType === "title") {
    return `intitle:${word}`;
  }
}

export default {
  getBooks(searchType, word) {
    return googleApi.get("volumes", {
      params: {
        q: getResource(searchType, word),
        Country: "JP",
        maxResults: 20,
        orderBy: "relevance"
      }
    });
  },
};

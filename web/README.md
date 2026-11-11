# LeetCode solutions explorer

Every solution in `../Codes` as an index card on a pinboard: filter by
language and topic, search titles and code, open a card to read the
highlighted source.

`scripts/build-index.mjs` runs before `dev` and `build`. It reads `../Codes`
and regenerates `src/data/solutions.json` (title, language, inferred topic
tags, line count and code), so a new solution shows up on the next deploy.
If `../Codes` is not available, the committed JSON is used as is.

Topic tags are inferred from keywords in the code, so treat them as a rough
guide. Clearer titles for abbreviated file names live in the `TITLES` map.

## Run locally

```bash
cd web
npm install
npm run dev
```

## Deploy to Vercel

Import the `Programs` repository and set **Root Directory** to `web`.
Keep "Include files outside the root directory in the Build Step" enabled
(the default) so the index script can read `../Codes`.

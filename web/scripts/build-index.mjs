// Builds src/data/solutions.json from the solution files in ../Codes.
// Runs before every build, so new solutions appear on the next deploy.
// If ../Codes is not available (for example a Vercel project that does not
// include files outside the root directory), the committed JSON is kept.
import fs from 'node:fs'
import path from 'node:path'
import { fileURLToPath } from 'node:url'

const here = path.dirname(fileURLToPath(import.meta.url))
const dir = process.env.CODES_DIR ?? path.resolve(here, '../../Codes')
const out = path.resolve(here, '../src/data/solutions.json')

if (!fs.existsSync(dir)) {
  console.log(`[index] ${dir} not found, keeping the existing solutions.json`)
  process.exit(0)
}

const SKIP_METHODS = new Set(['main', 'convert', 'helper', 'dfs', 'bfs', 'swap', 'reverse', 'toString', 'equals'])
const words = (s) =>
  s
    .replace(/_/g, ' ')
    .replace(/([a-z0-9])([A-Z])/g, '$1 $2')
    .replace(/([A-Z]+)([A-Z][a-z])/g, '$1 $2')
    .trim()
    .toLowerCase()
    .replace(/^./, (c) => c.toUpperCase())

function methodName(code, lang) {
  const re = lang === 'Java' ? /public\s+(?:static\s+)?[\w<>\[\],\s]+?\s+(\w+)\s*\(/g : /def\s+(\w+)\s*\(/g
  for (const m of code.matchAll(re)) if (!SKIP_METHODS.has(m[1]) && !m[1].startsWith('__')) return m[1]
  return null
}

const TOPICS = [
  ['Trees', /TreeNode|\.left\b|\.right\b/],
  ['Linked lists', /ListNode|\.next\b/],
  ['Matrix', /\[\]\[\]|matrix|grid\b/i],
  ['Hashing', /HashMap|HashSet|Map<|Set<|\bdict\(|\bset\(|Counter\(|\{\}/],
  ['Stack', /Stack<|Deque<|\bstack\b/],
  ['Binary search', /\bmid\b|lo\s*\+|left\s*\+\s*\(?right|low\s*\+/],
  ['Bit manipulation', /<<|\^|&\s*1\b|>>>|bitCount|n\s*>>\s*1|n\s*>>=/],
  ['Dynamic programming', /\bdp\b|\bdp\[/],
  ['Sorting', /Arrays\.sort|\.sort\(|sorted\(|mergeSort/],
  ['Two pointers', /\bleft\b[\s\S]*\bright\b|\bi\s*<\s*j\b|\bstart\b[\s\S]*\bend\b/],
  ['Strings', /String\b|charAt|\bstr\b|\.split\(|char\b/],
  ['Math', /%\s*10\b|Math\.(sqrt|pow|abs)|\bsqrt\b|\bpow\b/],
]

// Clearer names where the file or method name is an abbreviation.
const TITLES = {
  BTBSS1: 'Best time to buy and sell stock',
  BTBSS2: 'Best time to buy and sell stock II',
  Dissapeared: 'Find all numbers disappeared in an array',
  fibo: 'Fibonacci number',
  HammingWeight: 'Number of 1 bits',
  AddDig: 'Add digits',
  AddTwoNums: 'Add two numbers',
  CheckIfPowOf2: 'Power of two',
  PowOfThree: 'Power of three',
  PowOfFour: 'Power of four',
  RevBits: 'Reverse bits',
  RevString: 'Reverse string',
  RevWord: 'Reverse words in a string III',
  revLL: 'Reverse linked list',
  rev_vowels: 'Reverse vowels of a string',
  ValidPerfSq: 'Valid perfect square',
  Valid_parantheses: 'Valid parentheses',
  UglyNum: 'Ugly number',
  HappyNum: 'Happy number',
  GuessNumHiLow: 'Guess number higher or lower',
  IP_Defanger: 'Defanging an IP address',
  LL_to_decimal: 'Convert binary number in a linked list to integer',
  LongestPaliString: 'Longest palindromic substring',
  MergeSrotedLists: 'Merge two sorted lists',
  PascalsTri: "Pascal's triangle",
  MaxEnemyForts: 'Maximum enemy forts that can be captured',
  numIsIands: 'Number of islands',
  noOfEmployeeTarget: 'Number of employees who met the target',
  soln: 'Roman to integer',
  BST: 'Convert sorted array to binary search tree',
  rob: 'House robber',
  rand10: 'Implement rand10() using rand7()',
  midSearch: 'Search in rotated sorted array',
  Shuffle_array: 'Shuffle the array',
  evalRPN: 'Evaluate reverse Polish notation',
  find_diff: 'Find the difference',
  isomorphic: 'Isomorphic strings',
  jewels_stones: 'Jewels and stones',
  ransomnote: 'Ransom note',
  range_sum: 'Range sum query',
  Sum_range_BST: 'Range sum of BST',
  smaller_num_than_curr: 'How many numbers are smaller than the current number',
  richest_customer: 'Richest customer wealth',
  number_of_good_pairs: 'Number of good pairs',
  restore_string: 'Shuffle string',
  ThirdMax: 'Third maximum number',
  ZigZag: 'Zigzag conversion',
}

const files = fs.readdirSync(dir).filter((f) => /\.(java|py)$/.test(f)).sort((a, b) => a.localeCompare(b, 'en', { sensitivity: 'base' }))
const list = files.map((file) => {
  const code = fs.readFileSync(path.join(dir, file), 'utf8').replace(/\r\n/g, '\n').replace(/\t/g, '    ').trim()
  const lang = file.endsWith('.py') ? 'Python' : 'Java'
  const base = file.replace(/\.(java|py)$/, '')
  const method = methodName(code, lang)
  const title = TITLES[base] ?? words(base)
  let topics = TOPICS.filter(([, re]) => re.test(code)).map(([t]) => t)
  // Tree and list code always mentions left/right or next; that is not the two-pointer technique.
  if (topics.includes('Trees') || topics.includes('Linked lists')) topics = topics.filter((t) => t !== 'Two pointers' && t !== 'Binary search')
  topics = topics.slice(0, 3)
  return { id: file.replace(/\./g, '-').toLowerCase(), file, lang, title, method, lines: code.split('\n').length, topics: topics.length ? topics : ['Arrays'], code }
})

fs.mkdirSync(path.dirname(out), { recursive: true })
fs.writeFileSync(out, JSON.stringify(list))
console.log(`[index] ${list.length} solutions written to ${path.relative(process.cwd(), out)}`)

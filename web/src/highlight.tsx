import type { ReactNode } from 'react'

const KW = {
  Java: /\b(public|private|protected|class|static|final|void|int|long|double|float|boolean|char|byte|short|new|return|if|else|for|while|do|break|continue|switch|case|default|null|true|false|this|import|package|extends|implements|interface|try|catch|throw|throws)\b/,
  Python: /\b(def|class|return|if|elif|else|for|while|in|not|and|or|is|None|True|False|import|from|as|lambda|pass|break|continue|with|yield|try|except|raise|self)\b/,
}

/** Tiny highlighter: comments, strings, numbers, keywords, type names. */
export function highlight(line: string, lang: 'Java' | 'Python'): ReactNode[] {
  const comment = lang === 'Java' ? '\\/\\/.*$|\\/\\*.*?\\*\\/|^\\s*\\*.*$' : '#.*$'
  const re = new RegExp(`(${comment})|("(?:[^"\\\\]|\\\\.)*"|'(?:[^'\\\\]|\\\\.)*')|\\b(\\d+(?:\\.\\d+)?)\\b|${KW[lang].source}|\\b([A-Z][A-Za-z0-9_]*)\\b`, 'g')
  const out: ReactNode[] = []
  let last = 0
  for (const m of line.matchAll(re)) {
    const i = m.index!
    if (i > last) out.push(line.slice(last, i))
    const cls = m[1] ? 'text-mute italic' : m[2] ? 'text-[#2f7d4a]' : m[3] ? 'text-[#a35a00]' : m[4] ? 'font-semibold text-[#7a2f8f]' : 'text-[#2f6aa3]'
    out.push(<span key={i} className={cls}>{m[0]}</span>)
    last = i + m[0].length
  }
  out.push(line.slice(last))
  return out
}

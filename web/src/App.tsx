import { AnimatePresence, MotionConfig, motion } from 'motion/react'
import { useEffect, useMemo, useRef, useState } from 'react'
import data from './data/solutions.json'
import { highlight } from './highlight'

interface Sol { id: string; file: string; lang: 'Java' | 'Python'; title: string; lines: number; topics: string[]; code: string }
const all = data as Sol[]
const REPO = 'https://github.com/AdityaU101/Programs'
const EXPO = [0.16, 1, 0.3, 1] as const
const tilt = (id: string) => ((([...id].reduce((s, c) => s + c.charCodeAt(0), 0) % 9) - 4) * 0.45)

const topicCounts = Object.entries(all.reduce<Record<string, number>>((m, s) => { s.topics.forEach((t) => (m[t] = (m[t] ?? 0) + 1)); return m }, {})).sort((a, b) => b[1] - a[1])

function Card({ s, n, onOpen }: { s: Sol; n: number; onOpen: () => void }) {
  return (
    <motion.li layout initial={{ opacity: 0, y: 20, rotate: tilt(s.id) * 2 }} animate={{ opacity: 1, y: 0, rotate: tilt(s.id) }} exit={{ opacity: 0, scale: 0.9 }} transition={{ type: 'spring', stiffness: 260, damping: 24 }}
      whileHover={{ rotate: 0, y: -6, scale: 1.02, transition: { type: 'spring', stiffness: 400, damping: 22 } }}
      className="relative">
      <span className="absolute left-1/2 top-1.5 z-10 h-3.5 w-3.5 -translate-x-1/2 rounded-full bg-pin shadow-[0_2px_2px_rgb(0_0_0/0.35),inset_-2px_-2px_0_rgb(0_0_0/0.15)]" aria-hidden="true" />
      <button type="button" onClick={onOpen} style={{ backgroundPosition: '0 2.35rem, 0 2.35rem' }} className="card-lines flex h-full min-h-[11.5rem] w-full flex-col rounded-[2px] px-4 pb-3 pt-4 text-left shadow-[0_10px_18px_-10px_rgb(0_0_0/0.55)]">
        <span className="code flex justify-between text-[0.6875rem] text-mute">
          <span>No. {String(n).padStart(3, '0')}</span>
          <span style={{ color: s.lang === 'Java' ? 'var(--color-java)' : 'var(--color-python)' }}>{s.lang}</span>
        </span>
        <span className="casual mt-[1.05rem] block text-[1.25rem] font-semibold leading-[1.55rem]">{s.title}</span>
        <span className="mt-auto flex flex-wrap items-end gap-1 pt-3">
          {s.topics.map((t) => <span key={t} className="code rounded-[2px] border border-ink/25 px-1.5 text-[0.625rem] uppercase tracking-wide text-ink/70">{t}</span>)}
          <span className="code ml-auto text-[0.625rem] text-mute">{s.lines} lines</span>
        </span>
      </button>
    </motion.li>
  )
}

export default function App() {
  const [q, setQ] = useState('')
  const [topic, setTopic] = useState('All')
  const [lang, setLang] = useState<'All' | 'Java' | 'Python'>('All')
  const [open, setOpen] = useState<Sol | null>(null)
  const [copied, setCopied] = useState(false)
  const dlg = useRef<HTMLDialogElement>(null)

  const list = useMemo(() => {
    const s = q.trim().toLowerCase()
    return all.filter((x) => (topic === 'All' || x.topics.includes(topic)) && (lang === 'All' || x.lang === lang) && (!s || `${x.title} ${x.file} ${x.code}`.toLowerCase().includes(s)))
  }, [q, topic, lang])

  useEffect(() => {
    const d = dlg.current
    if (!d) return
    if (open && !d.open) d.showModal()
    if (!open && d.open) d.close()
  }, [open])

  const step = (dir: number) => {
    if (!open) return
    const i = list.findIndex((x) => x.id === open.id)
    const pool = i === -1 ? all : list
    const j = (Math.max(0, pool.findIndex((x) => x.id === open.id)) + dir + pool.length) % pool.length
    setOpen(pool[j])
  }
  const copy = async () => {
    if (!open) return
    try { await navigator.clipboard.writeText(open.code); setCopied(true); setTimeout(() => setCopied(false), 1200) } catch { /* ignore */ }
  }

  const java = all.filter((x) => x.lang === 'Java').length
  const chip = (on: boolean) => `casual min-h-9 rounded-full px-3.5 text-sm transition-colors ${on ? 'bg-card text-ink' : 'text-card/80 ring-1 ring-card/25 hover:text-card hover:ring-card/60'}`

  return (
    <MotionConfig reducedMotion="user">
      <header className="mx-auto flex max-w-[88rem] items-center justify-between px-5 py-5 text-sm text-card/80 md:px-10">
        <span className="code">Programs / LeetCode</span>
        <a href={REPO} target="_blank" rel="noreferrer" className="underline underline-offset-4 hover:text-card">Source</a>
      </header>

      <main className="mx-auto max-w-[88rem] px-5 pb-24 md:px-10">
        <section className="grid gap-x-12 gap-y-6 pb-10 pt-4 text-card lg:grid-cols-[1.2fr_1fr] lg:items-end">
          <h1 className="casual text-[clamp(3rem,8vw,7rem)] font-bold leading-[0.9] tracking-[-0.03em]">
            <motion.span className="block" initial={{ opacity: 0, y: 30 }} animate={{ opacity: 1, y: 0 }} transition={{ duration: 0.8, ease: EXPO }}>{all.length} problems,</motion.span>
            <motion.span className="block text-pin" initial={{ opacity: 0, y: 30 }} animate={{ opacity: 1, y: 0 }} transition={{ duration: 0.8, ease: EXPO, delay: 0.08 }}>pinned up.</motion.span>
          </h1>
          <div>
            <p className="max-w-md text-lg text-card/80">My LeetCode solutions, {java} in Java and {all.length - java} in Python. Written for clarity first and optimised where it was worth it. Pull a card to read the code.</p>
            <div className="mt-5 flex h-2.5 overflow-hidden rounded-full" role="img" aria-label={topicCounts.map(([t, c]) => `${t} ${c}`).join(', ')}>
              {topicCounts.map(([t, c], i) => <motion.span key={t} title={`${t}: ${c}`} className="h-full" style={{ background: `hsl(${40 + i * 23} 55% ${68 - (i % 3) * 8}%)` }} initial={{ width: 0 }} animate={{ width: `${(c / topicCounts.reduce((s, x) => s + x[1], 0)) * 100}%` }} transition={{ duration: 0.9, ease: EXPO, delay: 0.2 + i * 0.03 }} />)}
            </div>
            <p className="code mt-1.5 text-[0.6875rem] text-card/60">Topic mix, from tags inferred from each file</p>
          </div>
        </section>

        <section aria-label="Filters" className="sticky top-0 z-20 -mx-5 border-y border-card/15 bg-felt-dark/95 px-5 py-3 backdrop-blur md:-mx-10 md:px-10">
          <div className="flex flex-wrap items-center gap-2">
            <label className="relative min-w-[14rem] flex-1 sm:max-w-xs">
              <span className="sr-only">Search titles and code</span>
              <input value={q} onChange={(e) => setQ(e.target.value)} placeholder="Search titles and code…" className="code h-10 w-full rounded-full bg-card/10 px-4 text-sm text-card placeholder:text-card/50 ring-1 ring-card/25 focus:bg-card/15 focus:outline-none focus:ring-pin" />
            </label>
            <div role="group" aria-label="Language" className="flex gap-1">
              {(['All', 'Java', 'Python'] as const).map((l) => <button key={l} type="button" aria-pressed={lang === l} onClick={() => setLang(l)} className={chip(lang === l)}>{l === 'All' ? 'Java + Python' : l}</button>)}
            </div>
          </div>
          <div role="group" aria-label="Topic" className="mt-2 flex gap-1 overflow-x-auto pb-1">
            {[['All topics', all.length] as const, ...topicCounts].map(([t, c]) => (
              <button key={t} type="button" aria-pressed={topic === (t === 'All topics' ? 'All' : t)} onClick={() => setTopic(t === 'All topics' ? 'All' : t)} className={`${chip(topic === (t === 'All topics' ? 'All' : t))} shrink-0`}>{t} <span className="code text-[0.6875rem] opacity-60">{c}</span></button>
            ))}
          </div>
        </section>

        <p className="code mt-6 text-sm text-card/70" role="status">{list.length} card{list.length === 1 ? '' : 's'}</p>
        <motion.ol layout className="mt-4 grid grid-cols-1 gap-x-5 gap-y-7 sm:grid-cols-2 md:grid-cols-3 xl:grid-cols-5">
          <AnimatePresence mode="popLayout">
            {list.map((s) => <Card key={s.id} s={s} n={all.indexOf(s) + 1} onOpen={() => setOpen(s)} />)}
          </AnimatePresence>
        </motion.ol>
        {list.length === 0 && <p className="casual mt-10 text-3xl text-card/70">No card matches that. Try a shorter search.</p>}
      </main>

      <dialog ref={dlg} onClose={() => setOpen(null)} onKeyDown={(e) => { if (e.key === 'ArrowRight') step(1); if (e.key === 'ArrowLeft') step(-1) }} aria-labelledby="sol-title" className="m-auto w-[min(56rem,calc(100vw-1.5rem))] max-w-none bg-transparent p-0">
        {open && (
          <motion.div key={open.id} initial={{ opacity: 0, y: 30, rotate: -1.5 }} animate={{ opacity: 1, y: 0, rotate: 0 }} transition={{ type: 'spring', stiffness: 300, damping: 26 }} className="card-lines max-h-[88vh] overflow-auto rounded-[3px] px-5 pb-6 pt-4 shadow-2xl md:px-8">
            <div className="code flex items-center justify-between text-xs text-mute">
              <span>No. {String(all.indexOf(open) + 1).padStart(3, '0')} · {open.file}</span>
              <button type="button" onClick={() => setOpen(null)} className="flex h-10 w-10 items-center justify-center rounded-full text-lg hover:bg-ink/5" aria-label="Close">✕</button>
            </div>
            <h2 id="sol-title" className="casual mt-3 text-3xl font-bold leading-[1.55rem] md:text-4xl md:leading-[3.1rem]">{open.title}</h2>
            <p className="code mt-3 text-xs text-mute">{open.lang} · {open.lines} lines · {open.topics.join(', ')}</p>
            <pre className="code mt-5 overflow-x-auto rounded-[2px] bg-white/80 py-4 text-[0.8125rem] leading-[1.6] ring-1 ring-ink/10" tabIndex={0} aria-label={`${open.file} source`}>
              <code className="block min-w-max">
                {open.code.split('\n').map((l, i) => (
                  <span key={i} className="flex"><span className="w-10 shrink-0 select-none pr-3 text-right text-mute/60">{i + 1}</span><span className="whitespace-pre pr-6">{highlight(l, open.lang)}</span></span>
                ))}
              </code>
            </pre>
            <div className="mt-5 flex flex-wrap items-center gap-2">
              <button type="button" onClick={() => step(-1)} className="casual min-h-11 rounded-full px-4 ring-1 ring-ink/25 hover:bg-ink/5">← Previous</button>
              <button type="button" onClick={() => step(1)} className="casual min-h-11 rounded-full px-4 ring-1 ring-ink/25 hover:bg-ink/5">Next →</button>
              <span className="flex-1" />
              <button type="button" onClick={copy} className="casual min-h-11 rounded-full bg-ink px-4 text-card"><span aria-live="polite">{copied ? 'Copied' : 'Copy code'}</span></button>
              <a href={`${REPO}/blob/main/Codes/${encodeURIComponent(open.file)}`} target="_blank" rel="noreferrer" className="casual min-h-11 content-center rounded-full px-4 ring-1 ring-ink/25 hover:bg-ink/5">Open on GitHub</a>
            </div>
          </motion.div>
        )}
      </dialog>
    </MotionConfig>
  )
}

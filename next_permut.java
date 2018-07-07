boolean next_permutation(int[] p) {
  for (int a = p.length - 2; a >= 0; --a)
    if (p[a] < p[a + 1])
      for (int b = p.length - 1;; --b)
        if (p[b] > p[a]) {
          int t = p[a];
          p[a] = p[b];
          p[b] = t;
          for (++a, b = p.length - 1; a < b; ++a, --b) {
            t = p[a];
            p[a] = p[b];
            p[b] = t;
          }
          return true;
        }
  return false;
}

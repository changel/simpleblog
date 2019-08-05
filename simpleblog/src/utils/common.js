/**
 * 引用目录下所有指定格式文件
 *
 * @param r require.context()
 * @example importAll(require.context('src/xxx', false, /\.js$/))
 */
export function importAll (r) {
  return r.keys().map(r)
}

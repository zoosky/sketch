const app = require('./target/scala-2.12/sketch-fastopt.js')
app.Sketch.main()

module.hot.accept()
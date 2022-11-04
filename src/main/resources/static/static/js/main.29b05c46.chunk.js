(this["webpackJsonpchallenges-frontend"] = this["webpackJsonpchallenges-frontend"]
    || []).push([[0], {
  14: function (e, t, n) {
  }, 15: function (e, t, n) {
  }, 16: function (e, t, n) {
    "use strict";
    n.r(t);
    var a = n(0), s = n.n(a), r = n(5), l = n.n(r), u = (n(14), n(15), n(6)),
        o = n(2), c = n(3), i = n(1), h = n(7), m = n(8), g = function () {
          function e() {
            Object(o.a)(this, e)
          }

          return Object(c.a)(e, null, [{
            key: "challenge", value: function () {
              return fetch(e.SERVER_URL + e.GET_CHALLENGE)
            }
          }, {
            key: "sendGuess", value: function (t, n, a, s) {
              return fetch(e.SERVER_URL + e.POST_RESULT, {
                method: "POST",
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify(
                    {userAlias: t, factorA: n, factorB: a, guess: s})
              })
            }
          }]), e
        }();
    g.SERVER_URL = "http://localhost:8080", g.GET_CHALLENGE = "/challenges/random", g.POST_RESULT = "/attempts";
    var d = g, E = function (e) {
      Object(m.a)(n, e);
      var t = Object(h.a)(n);

      function n(e) {
        var a;
        return Object(o.a)(this, n), (a = t.call(this, e)).state = {
          a: "",
          b: "",
          user: "",
          message: "",
          guess: 0
        }, a.handleSubmitResult = a.handleSubmitResult.bind(
            Object(i.a)(a)), a.handleChange = a.handleChange.bind(
            Object(i.a)(a)), a
      }

      return Object(c.a)(n, [{
        key: "componentDidMount", value: function () {
          var e = this;
          d.challenge().then((function (t) {
            t.ok ? t.json().then((function (t) {
              e.setState({a: t.factorA, b: t.factorB})
            })) : e.updateMessage("Can't reach the server")
          }))
        }
      }, {
        key: "handleChange", value: function (e) {
          var t = e.target.name;
          this.setState(Object(u.a)({}, t, e.target.value))
        }
      }, {
        key: "handleSubmitResult", value: function (e) {
          var t = this;
          e.preventDefault(), d.sendGuess(this.state.user, this.state.a,
              this.state.b, this.state.guess).then((function (e) {
            e.ok ? e.json().then((function (e) {
              e.correct ? t.updateMessage(
                  "Congratulations! Your guess is correct") : t.updateMessage(
                  "Oops! Your guess " + e.resultAttempt
                  + " is wrong, but keep playing!")
            })) : t.updateMessage("Error: server error or not available")
          }))
        }
      }, {
        key: "updateMessage", value: function (e) {
          this.setState({message: e})
        }
      }, {
        key: "render", value: function () {
          return a.createElement("div", null, a.createElement("div", null,
                  a.createElement("h3", null, "Your new challenge is"),
                  a.createElement("h1", null, this.state.a, " x ", this.state.b)),
              a.createElement("form", {onSubmit: this.handleSubmitResult},
                  a.createElement("label", null, "Your alias:",
                      a.createElement("input", {
                        type: "text",
                        maxLength: "12",
                        name: "user",
                        value: this.state.user,
                        onChange: this.handleChange
                      })), a.createElement("br", null),
                  a.createElement("label", null, "Your guess:",
                      a.createElement("input", {
                        type: "number",
                        min: "0",
                        name: "guess",
                        value: this.state.guess,
                        onChange: this.handleChange
                      })), a.createElement("br", null),
                  a.createElement("input", {type: "submit", value: "Submit"})),
              a.createElement("h4", null, this.state.message))
        }
      }]), n
    }(a.Component);
    var f = function () {
      return s.a.createElement("div", {className: "App"},
          s.a.createElement("header", {className: "App-header"},
              s.a.createElement(E, null)))
    };
    Boolean("localhost" === window.location.hostname || "[::1]"
        === window.location.hostname || window.location.hostname.match(
            /^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));
    l.a.render(
        s.a.createElement(s.a.StrictMode, null, s.a.createElement(f, null)),
        document.getElementById("root")), "serviceWorker" in navigator
    && navigator.serviceWorker.ready.then((function (e) {
      e.unregister()
    })).catch((function (e) {
      console.error(e.message)
    }))
  }, 9: function (e, t, n) {
    e.exports = n(16)
  }
}, [[9, 1, 2]]]);
//# sourceMappingURL=main.29b05c46.chunk.js.map
package com.matrix.admin.oj.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author liuweizhong
 * @since 2024-10-15 22:42
 */
@Getter
@AllArgsConstructor
public enum ProgramLanguage {

    /**
     * 编程语言枚举
     */
    JAVA("Java"),
    C("C"),
    C_PLUS_PLUS("C++"),
    C_SHARP("C#"),
    GO("Go"),
    PYTHON("Python"),
    RUST("Rust"),
    RUBY("Ruby"),
    SCALA("Scala"),
    SWIFT("Swift"),
    KOTLIN("Kotlin"),
    JAVASCRIPT("JavaScript"),
    TYPESCRIPT("TypeScript"),
    COFFEE_SCRIPT("CoffeeScript"),
    ELM("Elm"),
    ERLANG("Erlang"),
    F_SHARP("F#"),
    HASKELL("Haskell"),
    LUA("Lua"),
    OCAML("OCaml"),
    PASCAL("Pascal"),
    PERL("Perl"),
    PHP("PHP"),
    R("R"),
    RUBY_ON_RAILS("Ruby on Rails"),
    RUST_SCRIPT("Rust Script"),
    SQL("SQL"),
    VBA("VBA"),
    VB_NET("VB.NET"),
    OTHER("Other");

    private final String language;

}

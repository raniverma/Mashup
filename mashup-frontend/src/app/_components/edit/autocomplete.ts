// tslint:disable-next-line:class-name
export class autocomplete {

    getCppCompletionProvider(monaco) {
        return {
            provideCompletionItems: function (model, position) {
                // tslint:disable-next-line:max-line-length
                const completionItems = [{ label: 'arrays', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'SQL', documentation: 'sql selector.'
            }
            ];
                return completionItems;
          }
        };
    }
    getCCompletionProvider(monaco) {
        return {
            provideCompletionItems: function (model, position) {
                // tslint:disable-next-line:max-line-length
                const completionItems = [{ label: 'basic', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'SQL', documentation: 'sql selector.' },
            ];
                return completionItems;
            }
        };
    }
    getPythonCompletionProvider(monaco) {
        return {
            provideCompletionItems: function (model, position) {
                // tslint:disable-next-line:max-line-length
                const completionItems = [{ label: 'print', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'SQL', documentation: 'sql selector.' }

            ];
                return completionItems;

            }
        };
    }
    getJavaCompletionProvider(monaco) {
        return {
            provideCompletionItems: function (model, position) {
                // tslint:disable-next-line:max-line-length
                const completionItems = [{ label: 'Integer', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'abstract', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'return', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'short', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'static', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'super', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'switch', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'this', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'throw', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'throws', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'try', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'void', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'int', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'while', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'if', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'else', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'elseif', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'assert', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'boolean', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'break', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'byte', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'case', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'catch', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'char', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'class', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'continue', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'default', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'do', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'extends', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'final', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'finally', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'float', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'interface', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'long', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'module', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'package', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'private', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'protected', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'public', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'short', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'null', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'true', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'false', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'double', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},
                { label: 'Map', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'java', documentation: 'sql selector.'},                
             ];
                
                return completionItems;
            }
        };
    }
}

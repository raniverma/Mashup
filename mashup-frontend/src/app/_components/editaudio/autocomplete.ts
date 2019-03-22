export class autocomplete {

    getCppCompletionProvider(monaco) {
        return {
            provideCompletionItems: function (model, position) {
                const completionItems = [{ label: 'arrays', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'SQL', documentation: 'sql selector.' }
            ];
                return completionItems;
            }
        };
    }
    getCCompletionProvider(monaco) {
        return {
            provideCompletionItems: function (model, position) {
                const completionItems = [{ label: 'basic', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'SQL', documentation: 'sql selector.' } ];
                return completionItems;
            }
        };
    }
    getPythonCompletionProvider(monaco) {
        return {
            provideCompletionItems: function (model, position) {
                const completionItems = [{ label: 'print', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'SQL', documentation: 'sql selector.' } ];
                return completionItems;
            }
        };
    }

    getJavaCompletionProvider(monaco) {
        return {
            provideCompletionItems: function (model, position) {
                const completionItems = [{ label: 'Integer', kind: monaco.languages.CompletionItemKind.Keyword, detail: 'SQL', documentation: 'sql selector.'} ];
                return completionItems;
            }
        };
    }
}

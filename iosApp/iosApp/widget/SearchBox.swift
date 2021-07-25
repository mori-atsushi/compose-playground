import SwiftUI
import shared

struct SearchBox: View {
    @State var value: String
    let onValueChange: (String) -> Void
    let onSubmit: () -> Void
    
    var body: some View {
        HStack {
            TextField(
                "",
                text: $value,
                onCommit: onSubmit
            )
        }.onChange(of: self.value, perform: { value in
            onValueChange(value)
        })
    }
}

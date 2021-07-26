import Combine
import shared

class ListViewModel: ObservableObject {
    typealias State = shared.ListViewModel.State
    enum Action {
        case submit
        case setUserName(userName: String)
        
        fileprivate var value: shared.ListViewModel.Action {
            get{
                switch self {
                case .submit:
                    return shared.ListViewModel.ActionSubmit()
                case .setUserName(userName: let userName):
                    return shared.ListViewModel.ActionSetUserName(userName: userName)
                }
            }
        }
    }

    @Published var state: State
    private let viewModel: IOSListViewModel
    
    init(_ viewModel: IOSListViewModel = ViewModelKt.getListViewModel()) {
        self.viewModel = viewModel
        self.state = viewModel.initialState
        self.viewModel.observeState { [unowned self] state in
            self.state = state
        }
    }
    
    func action(_ action: Action) {
        viewModel.action(action: action.value)
    }
    
    deinit {
        self.viewModel.clear()
    }
}

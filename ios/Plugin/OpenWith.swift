import Foundation
import UIKit

class OpenWith: NSObject {

    var controller: UIDocumentInteractionController?

    func openFile(path: String, viewController: UIViewController) {
        let fileURL = URL(fileURLWithPath: path)
        controller = UIDocumentInteractionController(url: fileURL)
        controller?.delegate = self
        controller?.presentOptionsMenu(from: viewController.view.bounds, in: viewController.view, animated: true)
    }
}

extension OpenWith: UIDocumentInteractionControllerDelegate {
    // Implement any delegate methods if necessary

    // Example:
    // func documentInteractionControllerViewControllerForPreview(_ controller: UIDocumentInteractionController) -> UIViewController {
    //     return someViewController
    // }
}

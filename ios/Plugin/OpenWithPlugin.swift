import Foundation
import Capacitor

@objc(OpenWithPlugin)
public class OpenWithPlugin: CAPPlugin {

    let openWith = OpenWith()

    @objc func openWith(_ call: CAPPluginCall) {
        guard let path = call.getString("path") else {
            call.reject("Path is required")
            return
        }

        DispatchQueue.main.async {
            if let viewController = self.bridge?.viewController {
                self.openWith.openFile(path: path, viewController: viewController)
                call.resolve(["message": "File opened successfully"])
            } else {
                call.reject("Failed to open file")
            }
        }
    }
}


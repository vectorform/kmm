//
//  AppDelegate.swift
//  iosApp
//
//  Created by Kevin Damore on 2/2/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import UIKit

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {

    var window: UIWindow?
    
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        window = UIWindow(frame: UIScreen.main.bounds)
        window?.rootViewController = JokeViewController()
        window?.makeKeyAndVisible()
        return true
    }
}

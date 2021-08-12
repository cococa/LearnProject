//
//  CounterButton.swift
//  MastingSwiftUICode
//
//  Created by sj on 2021/8/4.
//

import SwiftUI

struct CounterButton: View {
    
    @Binding var count : Int
    
    var body: some View {
        Button(action: {
            self.count += 1;
        }, label: {
            Circle()
                .foregroundColor(.red)
                .overlay(
                    Text("\(count)")
                        .foregroundColor(.white)
                        .font(.system(size: 30, weight: .bold, design: .monospaced))
                )
                .frame(width: 100, height: 100, alignment: .center)
        })
    }
}

struct CounterButton_Previews: PreviewProvider {
    static var previews: some View {
        CounterButton(count: .constant(11) )
    }
}

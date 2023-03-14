import { describe, it, expect } from "vitest";
import { mount } from "@vue/test-utils";
import { Quasar } from "quasar";
import ConcertListVue from "src/components/ConcertList.vue";

const wrapperFactory = () => mount(ConcertListVue, {
  global: {
    plugins: [Quasar]
  }
})

const wrapper = wrapperFactory();

describe('ConcertList', () => {
  it('mount component', () => {
    expect(ConcertListVue).toBeTruthy();
  });

  it.skip("returns empty string when no records are selected", () => {
    console.log(wrapper.html());
  });

  it('props', () => {
    const wrapper = mount(Component, {
      props: {
        count: 5
      }
    })
    expect(wrapper.html()).toContain('Count: 5')
  })

  it ("", () => {
    
  })
});
